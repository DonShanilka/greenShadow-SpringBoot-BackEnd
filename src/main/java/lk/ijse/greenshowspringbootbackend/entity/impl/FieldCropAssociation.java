package lk.ijse.greenshowspringbootbackend.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "fieldCropAssociation")
public class FieldCropAssociation {
    @Id
    private String id;
    @ManyToOne
    private Field field;
    @ManyToOne
    private Crop crop;
}
