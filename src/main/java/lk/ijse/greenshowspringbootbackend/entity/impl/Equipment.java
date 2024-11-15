package lk.ijse.greenshowspringbootbackend.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "equipment")
public class Equipment {
    @Id
    private String equipmentId;
    private String name;
    private String type;
    private String status;
    private int availableCount;
}
