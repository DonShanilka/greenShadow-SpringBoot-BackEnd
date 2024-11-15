package lk.ijse.greenshowspringbootbackend.exception;

public class CropNotFoundException extends RuntimeException {
    public CropNotFoundException(String message) {
        super(message);
    }
}
