package lk.ijse.greenshowspringbootbackend.controller;

import lk.ijse.greenshowspringbootbackend.dto.impl.*;
import lk.ijse.greenshowspringbootbackend.entity.impl.Log;
import lk.ijse.greenshowspringbootbackend.exception.DataPersistException;
import lk.ijse.greenshowspringbootbackend.service.LogService;
import lk.ijse.greenshowspringbootbackend.util.AppUtil;
import lk.ijse.greenshowspringbootbackend.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/log")
public class LogController {
    @Autowired
    LogService logService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SCIENTIST','MANAGER')")
    public ResponseEntity<Void> saveLog(
            @RequestParam("logDate") String date,
            @RequestParam("logDetails") String details,
            @RequestParam("logImage")MultipartFile image

    ) {
        try {
            byte[] imageBytes = image.getBytes();
            String imageBase64 = AppUtil.imageBase64(imageBytes);
            System.out.println("Log Image Eka: " + imageBase64);

            logService.saveLog(new LogDTO(date,details,imageBase64));
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{logCode}")
    @PreAuthorize("hasAnyRole('SCIENTIST','MANAGER')")
    public ResponseEntity<Void> deleteLog(@PathVariable("logCode") String logCode) {
        logService.deleteLog(logCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('SCIENTIST','MANAGER')")
    public ResponseUtil getAllLogs() {
        return new ResponseUtil("Done ", "Get All Logs ", logService.getLogs());
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SCIENTIST','MANAGER')")
    public ResponseEntity<Void> updateField(
            @RequestPart("logCode") String logCode,
            @RequestPart("logDate") String logDate,
            @RequestPart("logDetails") String logDetails,
            @RequestPart("image") MultipartFile image
    ) {

        try {

            byte[] byteProPic1 = image.getBytes();
            String base64proPic1 = AppUtil.imageBase64(byteProPic1);

            logService.updateLog(new LogDTO(logCode,logDate,logDetails,base64proPic1));

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/logCrops", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SCIENTIST','MANAGER')")
    public ResponseEntity<Void> saveLogCrops(@RequestBody CropLogDTO cropLogDTO) {
        logService.saveLogCrops(cropLogDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/logStaff", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SCIENTIST','MANAGER')")
    public ResponseEntity<Void> saveLogStaff(@RequestBody LogStaffDTO logStaffDTO) {
        logService.saveLogStaff(logStaffDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/logField", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SCIENTIST','MANAGER')")
    public ResponseEntity<Void> saveLogField(@RequestBody LogFieldDTO logFieldDTO) {
        logService.saveLogField(logFieldDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
