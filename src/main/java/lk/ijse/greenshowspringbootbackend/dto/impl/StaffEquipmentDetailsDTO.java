package lk.ijse.greenshowspringbootbackend.dto.impl;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffEquipmentDetailsDTO {
    @Id
    private String id;
    private int useEquipmentCount;
    private StaffDTO staffEntity;
    private EquipmentDTO equipmentEntity;
}
