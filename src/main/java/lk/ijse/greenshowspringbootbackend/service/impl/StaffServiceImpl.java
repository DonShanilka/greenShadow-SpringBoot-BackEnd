package lk.ijse.greenshowspringbootbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.greenshowspringbootbackend.dto.impl.FieldStaffDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.StaffDTO;
import lk.ijse.greenshowspringbootbackend.entity.impl.Field;
import lk.ijse.greenshowspringbootbackend.entity.impl.Staff;
import lk.ijse.greenshowspringbootbackend.exception.DataPersistException;
import lk.ijse.greenshowspringbootbackend.exception.StaffNotFoundException;
import lk.ijse.greenshowspringbootbackend.repo.FieldRepo;
import lk.ijse.greenshowspringbootbackend.repo.StaffRepo;
import lk.ijse.greenshowspringbootbackend.service.StaffService;
import lk.ijse.greenshowspringbootbackend.util.AppUtil;
import lk.ijse.greenshowspringbootbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
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
        return mapping.mapStaffEntitiesToDtos(staffRepo.findAll());
    }

    @Override
    public void saveFieldStaff(FieldStaffDTO fieldStaffDTO) {
        Optional<Field> fieldOptional = fieldRepo.findById(fieldStaffDTO.getFieldCode());
        Optional<Staff> staffOptional = staffRepo.findById(fieldStaffDTO.getStaffCode());

        if(!fieldOptional.isPresent() || !staffOptional.isPresent()) {
            throw new DataPersistException(fieldStaffDTO.getFieldCode() + " Or " + fieldStaffDTO.getStaffCode() + " does not exist");
        }

        Field field = fieldOptional.get();
        Staff staff = staffOptional.get();
        if (field.getStaffs().contains(staff)) {
            throw new DataPersistException("Field " + fieldStaffDTO.getFieldCode() + " already exists");
        }

        field.getStaffs().add(staff);
        staff.getFields().add(field);
        fieldRepo.save(field);
    }

    @Override
    public void deleteFieldStaff(String fieldCode, String staffCode) {
        Optional<Field> fieldOptional = fieldRepo.findById(fieldCode);
        Optional<Staff> staffOptional = staffRepo.findById(staffCode);

        if(!fieldOptional.isPresent() || !staffOptional.isPresent()) {
            throw new DataPersistException(fieldCode + " Or " + staffCode + " does not exist");
        }

        Field field = fieldOptional.get();
        Staff staff = staffOptional.get();

        field.getStaffs().remove(staff);
        staff.getFields().remove(field);
        fieldRepo.save(field);
    }
}
