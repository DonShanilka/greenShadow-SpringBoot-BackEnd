package lk.ijse.greenshowspringbootbackend.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vehicleStaffAssociation")
public class VehicleStaffAssociation {
    @Id
    private String id;
    @ManyToOne
    private Vehicle vehicle;
    @ManyToOne
    private Staff staff;
}
