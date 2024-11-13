package lk.ijse.greenshowspringbootbackend.dto.impl;

import jakarta.persistence.Id;
import lk.ijse.greenshowspringbootbackend.dto.EquipmentStatus;
import lk.ijse.greenshowspringbootbackend.dto.StaffEquipmentDetailsStatus;
import lk.ijse.greenshowspringbootbackend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipmentDTO implements SuperDTO, EquipmentStatus {
    @Id
    private String equipmentCode;
    private String Name;
    private String type;
    private String status;
    private int availableCount;
    private List<StaffEquipmentDetailsDTO> staffEquipmentDetailsList;
    private List<FieldDTO> fieldList;
}
