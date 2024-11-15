package lk.ijse.greenshowspringbootbackend.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "log")
public class Log {
    @Id
    private String logCode;
    private Date logDate;
    private String observationDetails;
    private String observedImage;

}
