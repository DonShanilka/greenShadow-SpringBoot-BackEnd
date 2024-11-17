package lk.ijse.greenshowspringbootbackend.service;

import lk.ijse.greenshowspringbootbackend.dto.impl.EquipmentDTO;
import lk.ijse.greenshowspringbootbackend.entity.impl.Equipment;

import java.io.FileNotFoundException;
import java.util.List;

public interface EquipmentService {
    void saveEquipment(EquipmentDTO equipmentDTO) throws FileNotFoundException;
    List<EquipmentDTO> getAllEquipment();
    EquipmentDTO getEquipmentById(String equipmentId);
    void updateEquipment(EquipmentDTO equipmentDTO) throws FileNotFoundException;
    void deleteEquipment(String equipmentId);
}
