package han.triptop.groepB3.authorisation;

import com.mashape.unirest.http.Unirest;
import org.springframework.stereotype.Component;

@Component
public class IdentityProviderClient {
    private static final String LOGIN_URL = "https://triptop-identity.wiremockapi.cloud/login";
    private static final String IS_LOGGED_IN_URL = "http://identity-wiremock.minordevops.nl:8080/checkAppAccess";


    public JsonResponse login(LoginDto login) {

    }

    public JsonResponse isLoggedIn(LoginTokenDto token) {

    }
}
