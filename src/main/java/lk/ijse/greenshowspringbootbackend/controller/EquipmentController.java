package lk.ijse.greenshowspringbootbackend.controller;

import lk.ijse.greenshowspringbootbackend.dto.impl.EquipmentDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.FieldDTO;
import lk.ijse.greenshowspringbootbackend.entity.impl.Equipment;
import lk.ijse.greenshowspringbootbackend.service.EquipmentService;
import lk.ijse.greenshowspringbootbackend.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveEquipment(
            @RequestPart("availableCount") String availableCount,
            @RequestPart("name") String name,
            @RequestPart("type") String type,
            @RequestPart("status") String status,
            @RequestPart("fieldIdOnEquipment") String fieldIdOnEquipment,
            @RequestPart("staffIdOnEquipment") String staffIdOnEquipment

    )   {
        try {
            equipmentService.saveEquipment(new EquipmentDTO(availableCount,name,type,status,fieldIdOnEquipment,staffIdOnEquipment));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateEquipment(@RequestBody EquipmentDTO equipmentDTO) throws FileNotFoundException {
        equipmentService.updateEquipment(equipmentDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{equipmentId}"})
    public ResponseEntity<Void> deleteEquipment(@PathVariable("equipmentId") String equipmentId) {
        equipmentService.deleteEquipment(equipmentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseUtil getAllEquipments() {
        return new ResponseUtil("Success", "Retrieved All Equipments", equipmentService.getAllEquipment());
    }
}
