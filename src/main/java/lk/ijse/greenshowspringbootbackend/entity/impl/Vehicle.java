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
@Table(name = "vehicle")
public class Vehicle {
    @Id
    private String vehicleCode;
    private String licensePlate;
    private String category;
    private String fuelType;
    private String status;
    private String remarks;
}
