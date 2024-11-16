package lk.ijse.greenshowspringbootbackend.controller;

import lk.ijse.greenshowspringbootbackend.dto.impl.CropDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.FieldDTO;
import lk.ijse.greenshowspringbootbackend.entity.impl.Field;
import lk.ijse.greenshowspringbootbackend.exception.DataPersistException;
import lk.ijse.greenshowspringbootbackend.service.CropService;
import lk.ijse.greenshowspringbootbackend.util.AppUtil;
import lk.ijse.greenshowspringbootbackend.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("api/v1/crops")
public class CropController {

    @Autowired
    private CropService cropService;

    @PostMapping(consumes =MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCrops(
            @RequestPart("cropName") String cropName,
            @RequestPart("scientificName") String scientificName,
            @RequestPart("cropImage") MultipartFile cropImage,
            @RequestPart("category") String category,
            @RequestPart("season") String season
    ) {
        try {
            byte[] imageBytes = cropImage.getBytes();
            String imageBase64 = AppUtil.imageBase64(imageBytes);

            cropService.saveFieldCrops(new CropDTO(cropName,scientificName,imageBase64,category,season));

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void updateCrop(){

    }

//    @GetMapping("/nextcode")
//    public ResponseUtil getNewCropCode() {
//        String newCropCode = AppUtil.generateCropCode(cropService.findLastCropCode());
//        return new ResponseUtil("Success", "Retrieved New Crop Code", newCropCode);
//    }
}
