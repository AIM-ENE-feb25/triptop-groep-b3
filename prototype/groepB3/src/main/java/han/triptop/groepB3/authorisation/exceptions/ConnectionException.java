package han.triptop.groepB3.authorisation.exceptions;

public class ConnectionException extends RuntimeException {
    public ConnectionException() {
        this((Throwable) null);
    }

    public ConnectionException(Throwable innerException) {
        this("The connection with the Identity provider client failed.", innerException);
    }

    public ConnectionException(String message) {
        this(message, null);
    }

    public ConnectionException(String message, Throwable innerException) {
        super(message, innerException);
    }
}
