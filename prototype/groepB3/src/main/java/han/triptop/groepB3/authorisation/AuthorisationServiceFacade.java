package han.triptop.groepB3.authorisation;

import han.triptop.groepB3.authorisation.exceptions.ConnectionException;
import han.triptop.groepB3.authorisation.exceptions.InvalidCredentialsException;
import han.triptop.groepB3.authorisation.exceptions.Result;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorisationServiceFacade {
    private final IdentityProviderClient client;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorisationServiceFacade(IdentityProviderClient client, JdbcTemplate template) {
        this.client = client;
        this.jdbcTemplate = template;
    }

    public LoginTokenDto login(LoginDto login) {
        Result<JsonResponse, Throwable> response = client.login(login);
        if (response.isError()) {
            throw new ConnectionException(response.getError());
        }

        JSONObject object = response.getValue().toJsonObject();
        JSONObject token = object.getJSONObject("token");
        String tokenValue = token.getString("value");

        jdbcTemplate.update("INSERT INTO Users (username, token) VALUES (?, ?)", login.username(), tokenValue);

        return new LoginTokenDto(tokenValue);
    }

    public boolean isLoggedIn(LoginTokenDto token) {
        String username;
        try {
            username = jdbcTemplate.queryForObject("SELECT username FROM Users WHERE token = ?", String.class, token.token());
        } catch (EmptyResultDataAccessException e) {
            return false;
        }

        Result<JsonResponse, Throwable> response = client.isLoggedIn(token, username);
        return response
                .map(jsonResponse -> jsonResponse.toJsonObject().getString("access").equals("allowed"))
                .orElseThrow(ConnectionException::new);
    }
}
