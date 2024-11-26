package lk.ijse.greenshowspringbootbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.greenshowspringbootbackend.dto.impl.EquipmentDTO;
import lk.ijse.greenshowspringbootbackend.entity.impl.Equipment;
import lk.ijse.greenshowspringbootbackend.entity.impl.Field;
import lk.ijse.greenshowspringbootbackend.entity.impl.Staff;
import lk.ijse.greenshowspringbootbackend.exception.DataPersistException;
import lk.ijse.greenshowspringbootbackend.exception.EquipmentNotFoundException;
import lk.ijse.greenshowspringbootbackend.exception.FieldNotFoundException;
import lk.ijse.greenshowspringbootbackend.exception.StaffNotFoundException;
import lk.ijse.greenshowspringbootbackend.repo.EquipmentRepo;
import lk.ijse.greenshowspringbootbackend.repo.FieldRepo;
import lk.ijse.greenshowspringbootbackend.repo.StaffRepo;
import lk.ijse.greenshowspringbootbackend.service.EquipmentService;
import lk.ijse.greenshowspringbootbackend.util.AppUtil;
import lk.ijse.greenshowspringbootbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentRepo equipmentRepo;
    @Autowired
    private StaffRepo staffRepo;
    @Autowired
    private FieldRepo fieldRepo;
    @Autowired
    private Mapping mapping;
    @Autowired
    private AppUtil appUtil;

    @Override
    public void saveEquipment(EquipmentDTO equipmentDTO) throws FileNotFoundException {
        String newEquipmentCode = appUtil.generateEquipmentId();

        if (equipmentRepo.existsById(newEquipmentCode)) {
            throw new DataPersistException("Crop ID " + newEquipmentCode + " already exists");
        }

        Optional<Staff> staff = staffRepo.findById(equipmentDTO.getStaffIdOnEquipment());
        Optional<Field> field = fieldRepo.findById(equipmentDTO.getFieldIdOnEquipment());
        if (!staff.isPresent()) {
            throw new StaffNotFoundException(equipmentDTO.getStaffIdOnEquipment() + " : Staff Does Not Exist");
        } else if (!field.isPresent()) {
            throw new FieldNotFoundException(equipmentDTO.getFieldIdOnEquipment() + " : Field Does Not Exist");
        }
        Equipment equipment = mapping.mapEquipmentDtoToEntity(equipmentDTO);
        equipment.setEquipmentId(newEquipmentCode);
        equipmentRepo.save(equipment);
    }

    @Override
    public List<EquipmentDTO> getAllEquipment() {
        return mapping.mapEquipmentEntitiesToDtos(equipmentRepo.findAll());
    }

    @Override
    public EquipmentDTO getEquipmentById(String equipmentId) {
        return null;
    }

    @Override
    public void updateEquipment(EquipmentDTO equipmentDTO) throws FileNotFoundException {
        if (!equipmentRepo.existsById(equipmentDTO.getEquipmentId())) {
            throw new EquipmentNotFoundException(equipmentDTO.getEquipmentId() + " - Equipment Not Exist");
        }
        Optional<Staff> staff = staffRepo.findById(equipmentDTO.getStaffIdOnEquipment());
        Optional<Field> field = fieldRepo.findById(equipmentDTO.getFieldIdOnEquipment());

        if (!staff.isPresent()){
            throw new StaffNotFoundException(equipmentDTO.getStaffIdOnEquipment() + " - Staff Dose Not Exist");
        } else if (!field.isPresent()) {
            throw new FileNotFoundException(equipmentDTO.getFieldIdOnEquipment() + " - Field Dose Not Exist");
        }
        equipmentRepo.save(mapping.mapEquipmentDtoToEntity(equipmentDTO));
    }

    @Override
    public void deleteEquipment(String equipmentId) {
        if (!equipmentRepo.existsById(equipmentId)){
            throw new EquipmentNotFoundException(equipmentId + " - Equipment Dose Not Exist");
        }
        equipmentRepo.deleteById(equipmentId);
    }
}
