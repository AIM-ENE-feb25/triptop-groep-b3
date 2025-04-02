package han.triptop.groepB3.authorisation;

import org.springframework.stereotype.Service;

@Service
public class AuthorisationServiceFacade {
    private final IdentityProviderClient client;

    public AuthorisationServiceFacade(IdentityProviderClient client) {
        this.client = client;
    }

    public LoginTokenDto login(LoginDto login) {

    }

    public boolean isLoggedIn(LoginTokenDto token) {

    }
}
