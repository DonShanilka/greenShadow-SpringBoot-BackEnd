package lk.ijse.greenshowspringbootbackend.dto.impl;

import lk.ijse.greenshowspringbootbackend.dto.SuperDTO;
import lk.ijse.greenshowspringbootbackend.dto.VehicleStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO implements SuperDTO, VehicleStatus {
    private String vehicleCode;
    private String licensePlate;
    private String category;
    private String fuelType;
    private String status;
    private String remarks;
}
