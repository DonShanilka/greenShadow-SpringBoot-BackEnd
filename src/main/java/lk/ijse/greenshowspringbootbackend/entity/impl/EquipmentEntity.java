package lk.ijse.greenshowspringbootbackend.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "equipment")
public class EquipmentEntity {
    @Id
    private String equipmentCode;
    private String name;
    private String type;
    private String status;
    private String availableCount;
}
