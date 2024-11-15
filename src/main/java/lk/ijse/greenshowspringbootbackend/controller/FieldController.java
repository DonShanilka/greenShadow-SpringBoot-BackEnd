package lk.ijse.greenshowspringbootbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lk.ijse.greenshowspringbootbackend.dto.impl.CropDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.FieldDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.StaffDTO;
import lk.ijse.greenshowspringbootbackend.exception.DataPersistException;
import lk.ijse.greenshowspringbootbackend.service.FieldService;
import lk.ijse.greenshowspringbootbackend.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/field")
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveField(
            @RequestPart("fieldName") String fieldName,
            @RequestPart("location") String location,
            @RequestPart("extentSize") Double extentSize,
            @RequestPart("fieldImage1") MultipartFile fieldImage1,
            @RequestPart("fieldImage2") MultipartFile fieldImage2,
            @RequestPart("crops") String cropsJson,
            @RequestPart("staff") String staffJson
    ) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<CropDTO> crops = objectMapper.readValue(cropsJson, List.class);
            List<StaffDTO> staff = objectMapper.readValue(staffJson, List.class);

            String fieldId = AppUtil.generateCropCode();

            var fieldDto = new FieldDTO();
            fieldDto.setFieldCode(fieldId);
            fieldDto.setFieldName(fieldName);
            fieldDto.setLocation(location);
            fieldDto.setExtentSize(extentSize);
            fieldDto.setFieldImage1(AppUtil.imageBase64(fieldImage1.getBytes()));
            fieldDto.setFieldImage2(AppUtil.imageBase64(fieldImage2.getBytes()));
            fieldDto.setCrops(crops);
            fieldDto.setStaff(staff);
            fieldService.saveField(fieldDto);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
