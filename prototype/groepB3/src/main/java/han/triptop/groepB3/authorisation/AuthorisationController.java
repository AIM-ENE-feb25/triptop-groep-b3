package han.triptop.groepB3.authorisation;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorisationController {
    private final AuthorisationServiceFacade authorisationService;

    public AuthorisationController(AuthorisationServiceFacade authorisationService) {
        this.authorisationService = authorisationService;
    }

    public ResponseEntity<?> login(LoginDto login) {

    }

    public ResponseEntity<Boolean> isLoggedIn() {

    }
}
