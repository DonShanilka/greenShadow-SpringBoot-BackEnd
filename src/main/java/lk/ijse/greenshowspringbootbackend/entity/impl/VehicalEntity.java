package lk.ijse.greenshowspringbootbackend.entity.impl;


    import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vehicle")
public class VehicalEntity {
        @Id
        private String vehicleCode;
        private String licensePlateNumber;
        private String Name;
        private String category;
        private String fuelType;
        private String remark;
        @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
        @JoinColumn(name = "memberCode")
        private StaffEntity staff;
}
