package lk.ijse.greenshowspringbootbackend.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @OneToMany(mappedBy = "equipmentEntity",cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<StaffEquipmrntDetailsEntity> staffEquipmentDetailsList;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "equipment_field_details",
            joinColumns = @JoinColumn(name = "equipmentCode"),
            inverseJoinColumns = @JoinColumn(name = "fieldCode")
    )
    private List<FieldEntity> fieldList;
}
