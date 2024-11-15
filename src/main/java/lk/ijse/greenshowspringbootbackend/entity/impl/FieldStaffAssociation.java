package lk.ijse.greenshowspringbootbackend.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "fieldStaffAssociation")
public class FieldStaffAssociation {
    @Id
    private String id;
    @ManyToOne
    private Field field;
    @ManyToOne
    private Staff staff;
}
