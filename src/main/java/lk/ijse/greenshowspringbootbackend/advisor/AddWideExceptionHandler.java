package lk.ijse.greenshowspringbootbackend.advisor;

import lk.ijse.greenshowspringbootbackend.exception.*;
import lk.ijse.greenshowspringbootbackend.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin
public class AddWideExceptionHandler {
//    @ExceptionHandler({FieldNotFoundException.class})
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseUtil handleFieldNotFoundException(FieldNotFoundException e) {
//        return new ResponseUtil("Error", e.getMessage(), null);
//    }
//
//    @ExceptionHandler({DataPersistException.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseUtil handleDataPersistException(DataPersistException e) {
//        return new ResponseUtil("Error", e.getMessage(), null);
//    }
//
//    @ExceptionHandler({CropNotFoundException.class})
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseUtil handleCropNotFoundException(CropNotFoundException e) {
//        return new ResponseUtil("Error", e.getMessage(), null);
//    }
//
//    @ExceptionHandler({LogNotFoundException.class})
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseUtil handleLogNotFoundException(LogNotFoundException e) {
//        return new ResponseUtil("Error", e.getMessage(), null);
//    }
//
//    @ExceptionHandler({StaffNotFoundException.class})
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseUtil handleStaffNotFoundException(StaffNotFoundException e) {
//        return new ResponseUtil("Error", e.getMessage(), null);
//    }
//
//    @ExceptionHandler({EquipmentNotFoundException.class})
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseUtil handleEquipmentNotFoundException(EquipmentNotFoundException e) {
//        return new ResponseUtil("Error", e.getMessage(), null);
//    }
//
//    @ExceptionHandler({VehicleNotFoundException.class})
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseUtil handleVehicleNotFoundException(VehicleNotFoundException e) {
//        return new ResponseUtil("Error", e.getMessage(), null);
//    }
//
//    @ExceptionHandler({RuntimeException.class})
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseUtil handleException(RuntimeException e) {
//        return new ResponseUtil("Error", e.getMessage(), null);
//    }
}
