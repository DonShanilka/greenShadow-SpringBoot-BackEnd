package lk.ijse.greenshowspringbootbackend.controller;

import lk.ijse.greenshowspringbootbackend.dto.impl.FieldDTO;
import lk.ijse.greenshowspringbootbackend.exception.DataPersistException;
import lk.ijse.greenshowspringbootbackend.service.FieldService;
import lk.ijse.greenshowspringbootbackend.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/field")
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SCIENTIST','MANAGER')")
    public ResponseEntity<Void> saveField(
            @RequestPart("fieldName") String fieldName,
            @RequestPart("location") String location,
            @RequestPart("extentSize") String extentSize,
            @RequestPart("fieldImage1") MultipartFile fieldImage1,
            @RequestPart("fieldImage2") MultipartFile fieldImage2
    ) {

        try {

            byte[] byteProPic1 = fieldImage1.getBytes();
            String base64proPic1 = AppUtil.imageBase64(byteProPic1);

            byte[] byteProPic2 = fieldImage2.getBytes();
            String base64proPic2 = AppUtil.imageBase64(byteProPic2);

            fieldService.saveField(new FieldDTO(fieldName,location,extentSize,base64proPic1,base64proPic2));

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SCIENTIST','MANAGER')")
    public ResponseEntity<Void> updateField(
            @RequestPart("fieldCode") String fieldCode,
            @RequestPart("fieldName") String fieldName,
            @RequestPart("location") String location,
            @RequestPart("extentSize") String extentSize,
            @RequestPart("fieldImage1") MultipartFile fieldImage1,
            @RequestPart("fieldImage2") MultipartFile fieldImage2
    ) {

        try {

            byte[] byteProPic1 = fieldImage1.getBytes();
            String base64proPic1 = AppUtil.imageBase64(byteProPic1);

            byte[] byteProPic2 = fieldImage2.getBytes();
            String base64proPic2 = AppUtil.imageBase64(byteProPic2);

            fieldService.updateField(new FieldDTO(fieldCode,fieldName,location,extentSize,base64proPic1,base64proPic2));

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{fieldCode}")
    @PreAuthorize("hasAnyRole('SCIENTIST','MANAGER')")
    public ResponseEntity<Void> deleteField(@PathVariable("fieldCode") String fieldCode) throws FileNotFoundException {
        fieldService.deleteFieldById(fieldCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SCIENTIST','MANAGER')")
    public List<FieldDTO> getAllFields() {
       return fieldService.getAllField();
    }

}
