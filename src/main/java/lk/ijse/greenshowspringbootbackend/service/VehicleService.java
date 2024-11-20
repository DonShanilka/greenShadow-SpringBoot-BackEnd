package lk.ijse.greenshowspringbootbackend.service;

import lk.ijse.greenshowspringbootbackend.dto.impl.VehicleDTO;
import lk.ijse.greenshowspringbootbackend.entity.impl.Vehicle;

import java.util.List;

public interface VehicleService {
    void save(VehicleDTO vehicleDTO);
    void update(VehicleDTO vehicleDTO);
    void delete(String vehicleCode);
    List<VehicleDTO> getAllVehicles();
}
