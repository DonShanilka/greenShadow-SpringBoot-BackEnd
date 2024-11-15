package lk.ijse.greenshowspringbootbackend.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "logFieldAssociation")
public class LogFieldAssociation {
    @Id
    private String id;
    @ManyToOne
    private Log log;
    @ManyToOne
    private Field field;
}
