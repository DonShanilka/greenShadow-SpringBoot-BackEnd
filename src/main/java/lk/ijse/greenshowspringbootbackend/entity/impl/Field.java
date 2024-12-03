package lk.ijse.greenshowspringbootbackend.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "field")
public class Field {
    @Id
    private String fieldCode;
    private String fieldName;
    private String location;
    private String extentSize;
    @Column(columnDefinition = "LONGTEXT")
    private String fieldImage1;
    @Column(columnDefinition = "LONGTEXT")
    private String fieldImage2;

    @ManyToMany(mappedBy = "fields", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Log> logs;

    @OneToMany(mappedBy = "field", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Staff> staff;

    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL)
    private List<Equipment> equipment;

    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL)
    private List<Crop> crop;
}
