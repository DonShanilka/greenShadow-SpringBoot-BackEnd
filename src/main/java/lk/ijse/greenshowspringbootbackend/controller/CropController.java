package lk.ijse.greenshowspringbootbackend.controller;

import lk.ijse.greenshowspringbootbackend.dto.impl.CropDTO;
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

@CrossOrigin
@RestController
@RequestMapping("api/v1/crops")
public class CropController {

    @Autowired
    private CropService cropService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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

    @PutMapping(value = "{cropCode}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateCrops(
            @RequestPart("cropName") String cropName,
            @RequestPart("scientificName") String scientificName,
            @RequestPart("cropImage") MultipartFile cropImage,
            @RequestPart("category") String category,
            @RequestPart("season") String season,
            @PathVariable("cropCode") String cropCode
    ) {

        String imageBase64 = "";

        try {
            byte[] imageBytes = cropImage.getBytes();
            imageBase64 = AppUtil.imageBase64(imageBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        var dtos = new CropDTO();
        dtos.setCropCode(cropCode);
        dtos.setCropName(cropName);
        dtos.setScientificName(scientificName);
        dtos.setCropImage(imageBase64);
        dtos.setCategory(category);
        dtos.setSeason(season);

        cropService.updateFieldCrops(cropCode,dtos);
    }

    @DeleteMapping("/{cropCode}")
    public ResponseEntity<Void> deleteCrop(@PathVariable("cropCode") String cropCode) {
        cropService.deleteCrop(cropCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseUtil getAllCrops() {
        return new ResponseUtil("Success" ,"Get All Crops", cropService.getAllCrops());
    }

}
