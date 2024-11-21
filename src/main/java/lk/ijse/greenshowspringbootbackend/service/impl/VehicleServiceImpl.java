package lk.ijse.greenshowspringbootbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.greenshowspringbootbackend.dto.impl.VehicleDTO;
import lk.ijse.greenshowspringbootbackend.entity.impl.Staff;
import lk.ijse.greenshowspringbootbackend.entity.impl.Vehicle;
import lk.ijse.greenshowspringbootbackend.exception.DataPersistException;
import lk.ijse.greenshowspringbootbackend.exception.StaffNotFoundException;
import lk.ijse.greenshowspringbootbackend.exception.VehicleNotFoundException;
import lk.ijse.greenshowspringbootbackend.repo.StaffRepo;
import lk.ijse.greenshowspringbootbackend.repo.VehicleRepo;
import lk.ijse.greenshowspringbootbackend.service.VehicleService;
import lk.ijse.greenshowspringbootbackend.util.AppUtil;
import lk.ijse.greenshowspringbootbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepo vehicleRepo;
    @Autowired
    private StaffRepo staffRepo;
    @Autowired
    private Mapping mapping;
    @Autowired
    private AppUtil appUtil;

    @Override
    public void save(VehicleDTO vehicleDTO) {
        String newVehicleCode = appUtil.generateVehicleId();
        // Check if the new ID already exists in the database
        if (vehicleRepo.existsById(newVehicleCode)) {
            throw new DataPersistException("Vehicle ID " + newVehicleCode + " already exists");
        } else if (!staffRepo.existsById(vehicleDTO.getStaffId())) {
            throw new StaffNotFoundException(vehicleDTO.getStaffId());
        }

        // Map the CropDTO to a Crop entity and set the generated ID
        Vehicle vehicle = mapping.mapVehicleDtoToEntity(vehicleDTO);
        vehicle.setVehicleCode(newVehicleCode);
        // Save the crop entity to the database
        vehicleRepo.save(vehicle);
    }

    @Override
    public void update(VehicleDTO vehicleDTO) {
        if (!vehicleRepo.existsById(vehicleDTO.getVehicleCode())) {
            throw new VehicleNotFoundException(vehicleDTO.getVehicleCode() + " does not exist");
        } else if (!staffRepo.existsById(vehicleDTO.getStaffId())) {
            throw new StaffNotFoundException(vehicleDTO.getStaffId() + " does not exist");
        }
        vehicleRepo.save(mapping.mapVehicleDtoToEntity(vehicleDTO));
    }

    @Override
    public void delete(String vehicleCode) {
        if (!vehicleRepo.existsById(vehicleCode)) {
            throw new VehicleNotFoundException(vehicleCode + " does not exist");
        }
        vehicleRepo.deleteById(vehicleCode);
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return List.of();
    }
}
