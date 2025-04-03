package han.triptop.groepB3.authorisation;

import han.triptop.groepB3.authorisation.exceptions.InvalidCredentialsException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthorisationExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<String> invalidCredentialsException(InvalidCredentialsException ex) {
        return ResponseEntity.status(HttpStatusCode.valueOf(401))
                .body(ex.getMessage());
    }
}
