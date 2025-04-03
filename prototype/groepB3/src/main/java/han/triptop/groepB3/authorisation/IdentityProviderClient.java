package han.triptop.groepB3.authorisation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import han.triptop.groepB3.authorisation.exceptions.InvalidCredentialsException;
import han.triptop.groepB3.authorisation.exceptions.Result;
import org.json.JSONObject;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IdentityProviderClient {
    private static final String LOGIN_URL = "https://triptop-identity.wiremockapi.cloud/login";
    private static final String IS_LOGGED_IN_URL = "http://identity-wiremock.minordevops.nl:8080/checkAppAccess";


    public Result<JsonResponse, Throwable> login(LoginDto login) {
        String response;
        try {
            ObjectMapper mapper = new ObjectMapper();
            HttpResponse<String> httpResponse = Unirest.post(LOGIN_URL)
                    .body(mapper.writeValueAsString(login))
                    .asString();

            if (httpResponse.getStatus() < 200 || httpResponse.getStatus() >= 300) {
                throw new InvalidCredentialsException();
            }

            response = httpResponse.getBody();
        } catch (UnirestException | JsonProcessingException e) {
            return Result.fromError(e);
        }

        return Result.fromValue(new JsonResponse(response));
    }

    public Result<JsonResponse, Throwable> isLoggedIn(LoginTokenDto token, String username) {
        String response;
        try {
            HttpResponse<String> httpResponse = Unirest.post(IS_LOGGED_IN_URL + "?token=" + token.token())
                    .body(new JSONObject("{\"username\":\"" + username + "\",\"application\":\"triptop\"}"))
                    .asString();

            if (httpResponse.getStatus() < 200 || httpResponse.getStatus() >= 300) {
                throw new RuntimeException();
            }

            response = httpResponse.getBody();
        } catch (UnirestException e) {
            return Result.fromError(e);
        }

        return Result.fromValue(new JsonResponse(response));
    }
}
