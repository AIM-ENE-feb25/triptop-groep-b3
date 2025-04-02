package han.triptop.groepB3.authorisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authorisation")
public class AuthorisationController {
    private final AuthorisationServiceFacade authorisationService;

    @Autowired
    public AuthorisationController(AuthorisationServiceFacade authorisationService) {
        this.authorisationService = authorisationService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto login) {
        LoginTokenDto token = authorisationService.login(login);
        return ResponseEntity.ok()
                .header("Set-Cookie", "login-token=" + token.token() + "; HttpOnly; Secure; SameSite=None; path=/;")
                .body(null);
    }

    @GetMapping("/logged-in")
    public ResponseEntity<Boolean> isLoggedIn(@CookieValue("login-token") String loginToken) {
        return ResponseEntity.ok()
                .body(authorisationService.isLoggedIn(new LoginTokenDto(loginToken)));
    }
}
