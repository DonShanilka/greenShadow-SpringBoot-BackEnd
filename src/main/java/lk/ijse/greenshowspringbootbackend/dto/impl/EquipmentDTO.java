package lk.ijse.greenshowspringbootbackend.dto.impl;

import lk.ijse.greenshowspringbootbackend.dto.EquipmentStatus;
import lk.ijse.greenshowspringbootbackend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipmentDTO implements SuperDTO, EquipmentStatus {
    private String equipmentId;
    private String availableCount;
    private String name;
    private String type;
    private String status;
    private String fieldIdOnEquipment;
    private String staffIdOnEquipment;

    public EquipmentDTO(String name, String availableCount, String type,String status ,String fieldIdOnEquipment, String staffIdOnEquipment) {
        this.name = name;
        this.availableCount = availableCount;
        this.type = type;
        this.status = status;
        this.fieldIdOnEquipment = fieldIdOnEquipment;
        this.staffIdOnEquipment = staffIdOnEquipment;
    }
}
