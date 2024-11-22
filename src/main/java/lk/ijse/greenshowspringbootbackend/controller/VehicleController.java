package lk.ijse.greenshowspringbootbackend.controller;

import lk.ijse.greenshowspringbootbackend.dto.impl.VehicleDTO;
import lk.ijse.greenshowspringbootbackend.entity.impl.Vehicle;
import lk.ijse.greenshowspringbootbackend.service.VehicleService;
import lk.ijse.greenshowspringbootbackend.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.save(vehicleDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateVehicle(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.update(vehicleDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{vehicleCode}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable("vehicleCode") String userCode) {
        vehicleService.delete(userCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseUtil getAllVehicles() {
        return new ResponseUtil("Don"," Get All Vehicle ",vehicleService.getAllVehicles());
    }

}
