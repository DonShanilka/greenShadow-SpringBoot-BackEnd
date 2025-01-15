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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;


@RestController
@RequestMapping("api/v1/crops")
@CrossOrigin(origins = "*")
public class CropController {

    @Autowired
    private CropService cropService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SCIENTIST','MANAGER')")
    public ResponseEntity<Void> saveCrops(
            @RequestPart("cropName") String cropName,
            @RequestPart("scientificName") String scientificName,
            @RequestPart("cropImage") MultipartFile cropImage,
            @RequestPart("category") String category,
            @RequestPart("season") String season,
            @RequestPart("fieldCode") String fieldCode
    ) {
        try {
            byte[] imageBytes = cropImage.getBytes();
            String imageBase64 = AppUtil.imageBase64(imageBytes);
            System.out.println(fieldCode);
            System.out.println(cropName + scientificName+imageBase64+category+season+fieldCode);
            cropService.saveFieldCrops(new CropDTO(cropName,scientificName,imageBase64,category,season,fieldCode));

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SCIENTIST','MANAGER')")
    public void updateCrops(
            @RequestPart("cropCode") String cropCode,
            @RequestPart("cropName") String cropName,
            @RequestPart("scientificName") String scientificName,
            @RequestPart("cropImage") MultipartFile cropImage,
            @RequestPart("category") String category,
            @RequestPart("season") String season,
            @RequestPart("fieldCode") String fieldCode
    ) throws FileNotFoundException {

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
        dtos.setFieldCode(fieldCode);
        System.out.println(dtos);
        cropService.updateFieldCrops(dtos);
    }

    @DeleteMapping("/{cropCode}")
    @PreAuthorize("hasAnyRole('SCIENTIST','MANAGER')")
    public ResponseEntity<Void> deleteCrop(@PathVariable("cropCode") String cropCode) {
        cropService.deleteCrop(cropCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('SCIENTIST','MANAGER')")
    public ResponseUtil getAllCrops() {
        return new ResponseUtil("Success" ,"Get All Crops", cropService.getAllCrops());
    }
}
