package lk.ijse.greenshowspringbootbackend.exception;

public class StaffNotFoundException extends RuntimeException{
    public StaffNotFoundException() {
    }

    public StaffNotFoundException(String message) {
        super(message);
    }

    public StaffNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
