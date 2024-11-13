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
@Table(name = "logs")
public class LogEntity {
    @Id
    private String logCode;
    private String logDetails;
    private String logDate;
    @Column(columnDefinition = "LONGTEXT")
    private String observerdImage;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "staff_log_detaails",
            joinColumns = @JoinColumn(name = "logCode"),
            inverseJoinColumns = @JoinColumn(name = "memberCode")
    )
    private List<StaffEntity> staffList;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "log_crop_details",
            joinColumns = @JoinColumn(name = "logCode"),
            inverseJoinColumns = @JoinColumn(name = "cropcode")
    )
    private List<CropEntity> cropList;
    @ManyToMany(mappedBy = "logList",cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<FieldEntity> fieldList;
}
