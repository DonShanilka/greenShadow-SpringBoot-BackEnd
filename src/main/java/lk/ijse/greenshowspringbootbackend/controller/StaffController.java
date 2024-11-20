package lk.ijse.greenshowspringbootbackend.controller;

import lk.ijse.greenshowspringbootbackend.dto.impl.StaffDTO;
import lk.ijse.greenshowspringbootbackend.entity.impl.Staff;
import lk.ijse.greenshowspringbootbackend.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveStaff(@RequestBody StaffDTO staffDTO) {
        staffService.saveStaff(staffDTO);
        return new  ResponseEntity<>(HttpStatus.CREATED);
    }
}
