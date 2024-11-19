package lk.ijse.greenshowspringbootbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.greenshowspringbootbackend.dto.impl.FieldStaffDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.StaffDTO;
import lk.ijse.greenshowspringbootbackend.entity.impl.Crop;
import lk.ijse.greenshowspringbootbackend.entity.impl.Staff;
import lk.ijse.greenshowspringbootbackend.exception.DataPersistException;
import lk.ijse.greenshowspringbootbackend.exception.StaffNotFoundException;
import lk.ijse.greenshowspringbootbackend.repo.FieldRepo;
import lk.ijse.greenshowspringbootbackend.repo.StaffRepo;
import lk.ijse.greenshowspringbootbackend.service.SataffService;
import lk.ijse.greenshowspringbootbackend.util.AppUtil;
import lk.ijse.greenshowspringbootbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
@Transactional
public class SataffServiceImpl implements SataffService {
    @Autowired
    private StaffRepo staffRepo;
    @Autowired
    private FieldRepo fieldRepo;
    @Autowired
    private Mapping mapping;
    @Autowired
    private AppUtil appUtil;

    @Override
    public void saveStaff(StaffDTO staffDTO) {
        String newStaffCrop = appUtil.generateStaffId();
        // Check if the new ID already exists in the database
        if (staffRepo.existsById(newStaffCrop)) {
            throw new DataPersistException("Crop ID " + newStaffCrop + " already exists");
        }
        // Map the CropDTO to a Crop entity and set the generated ID
        Staff staffEntity = mapping.mapStaffDtoToEntity(staffDTO);
        staffEntity.setId(newStaffCrop);
        // Save the crop entity to the database
        staffRepo.save(staffEntity);
    }

    @Override
    public void updateStaff(StaffDTO staffDTO) {
        if (!staffRepo.existsById(staffDTO.getId())) {
            throw new StaffNotFoundException("Staff code " + staffDTO.getId() + " does not exist");
        }
        staffRepo.save(mapping.mapStaffDtoToEntity(staffDTO));
    }

    @Override
    public void deleteStaff(String staffCode) {
        if (!staffRepo.existsById(staffCode)) {
            throw new StaffNotFoundException("Staff ID " + staffCode + " does not exist");
        }
        staffRepo.deleteById(staffCode);
    }

    @Override
    public List<StaffDTO> getAllStaffs() {
        return List.of();
    }

    @Override
    public void saveFieldStaff(FieldStaffDTO fieldStaffDTO) {

    }

    @Override
    public void deleteFieldStaff(String fieldCode, String staffCode) {

    }
}
