package lk.ijse.greenshowspringbootbackend.exception;

public class FieldNotFoundException extends RuntimeException {
    public FieldNotFoundException() {
    }

    public FieldNotFoundException(String message) {
        super(message);
    }

    public FieldNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
