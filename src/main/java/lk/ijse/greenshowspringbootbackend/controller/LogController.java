package lk.ijse.greenshowspringbootbackend.controller;

import lk.ijse.greenshowspringbootbackend.dto.impl.CropDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.FieldDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.LogDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.StaffDTO;
import lk.ijse.greenshowspringbootbackend.entity.impl.Log;
import lk.ijse.greenshowspringbootbackend.service.LogService;
import lk.ijse.greenshowspringbootbackend.util.AppUtil;
import lk.ijse.greenshowspringbootbackend.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/log")
public class LogController {
    @Autowired
    LogService logService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveLog(
            @RequestParam("date") Date date,
            @RequestParam("details") String details,
            @RequestParam("image")MultipartFile image
//            @RequestParam("date") List<String> logFields,
//            @RequestParam("date") List<String> logCrops,
//            @RequestParam("date") List<String> logStaffs

    ) {
        try {
            byte[] imageBytes = image.getBytes();
            String imageBase64 = AppUtil.imageBase64(imageBytes);

//            List<FieldDTO> fieldDTOS = new ArrayList<>();
//            for (String logField : logFields) {
//                FieldDTO fieldDTO = new FieldDTO();
//                fieldDTO.setFieldCode(logField);
//                fieldDTOS.add(fieldDTO);
//            }
//
//            List<CropDTO> cropDTOS = new ArrayList<>();
//            for (String logCrop : logCrops) {
//                CropDTO cropDTO = new CropDTO();
//                cropDTO.setCropCode(logCrop);
//                cropDTOS.add(cropDTO);
//            }
//
//            List<StaffDTO> staffDTOS = new ArrayList<>();
//            for (String logStaff : logStaffs) {
//                StaffDTO staffDTO = new StaffDTO();
//                staffDTO.setId(logStaff);
//                staffDTOS.add(staffDTO);
//            }

            logService.saveLog(new LogDTO(date,details,imageBase64));
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{logCode}")
    public ResponseEntity<Void> deleteLog(@PathVariable("logCode") String logCode) {
        logService.deleteLog(logCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseUtil getAllLogs() {
        return new ResponseUtil("Done", "Get All Logs", logService.getLogs());
    }
}
