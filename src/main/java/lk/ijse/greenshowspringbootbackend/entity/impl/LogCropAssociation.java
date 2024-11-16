package lk.ijse.greenshowspringbootbackend.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "logCropAssociation")
public class LogCropAssociation {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @ManyToOne
    private Log log;
    @ManyToOne
    private Crop crop;
}
