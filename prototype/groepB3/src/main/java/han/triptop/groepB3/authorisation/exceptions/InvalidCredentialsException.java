package han.triptop.groepB3.authorisation.exceptions;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException() {
        this((Throwable) null);
    }

    public InvalidCredentialsException(Throwable innerException) {
        this("The username and or password is invalid.", innerException);
    }

    public InvalidCredentialsException(String message) {
        this(message, null);
    }

    public InvalidCredentialsException(String message, Throwable innerException) {
        super(message, innerException);
    }
}
