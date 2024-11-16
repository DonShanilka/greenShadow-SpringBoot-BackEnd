package lk.ijse.greenshowspringbootbackend.exception;

public class EquipmentNotFoundException extends RuntimeException {
    public EquipmentNotFoundException() {
    }

    public EquipmentNotFoundException(String message) {
        super(message);
    }

    public EquipmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
