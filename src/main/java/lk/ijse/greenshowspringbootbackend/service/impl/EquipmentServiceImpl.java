package lk.ijse.greenshowspringbootbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.greenshowspringbootbackend.dto.impl.EquipmentDTO;
import lk.ijse.greenshowspringbootbackend.entity.impl.Equipment;
import lk.ijse.greenshowspringbootbackend.entity.impl.Field;
import lk.ijse.greenshowspringbootbackend.entity.impl.Staff;
import lk.ijse.greenshowspringbootbackend.exception.DataPersistException;
import lk.ijse.greenshowspringbootbackend.exception.StaffNotFoundException;
import lk.ijse.greenshowspringbootbackend.repo.EquipmentRepo;
import lk.ijse.greenshowspringbootbackend.repo.FieldRepo;
import lk.ijse.greenshowspringbootbackend.repo.StaffRepo;
import lk.ijse.greenshowspringbootbackend.service.EquipmentService;
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

    @Override
    public void saveEquipment(EquipmentDTO equipmentDTO) throws FileNotFoundException {
        if (equipmentRepo.existsById(String.valueOf(equipmentDTO.getEquipmentId()))){
            throw new DataPersistException(equipmentDTO.getEquipmentId() + " - Equipment already exists");
        }
        Optional<Staff> staff = staffRepo.findById(equipmentDTO.getStaffId());
        Optional<Field> field = fieldRepo.findById(equipmentDTO.getFieldId());

        if (!staff.isPresent()){
            throw new StaffNotFoundException(equipmentDTO.getStaffId() + " - Staff Dose Not Exist");
        } else if (!field.isPresent()){
            throw new FileNotFoundException(equipmentDTO.getEquipmentId() + " - Field Dose Not Exist");
        }
        equipmentRepo.save(mapping.mapEquipmentDtoToEntity(equipmentDTO));
    }

    @Override
    public List<EquipmentDTO> getAllEquipment() {
        return List.of();
    }

    @Override
    public EquipmentDTO getEquipmentById(String equipmentId) {
        return null;
    }

    @Override
    public void updateEquipment(EquipmentDTO equipmentDTO) {

    }

    @Override
    public void deleteEquipment(String equipmentId) {

    }
}
