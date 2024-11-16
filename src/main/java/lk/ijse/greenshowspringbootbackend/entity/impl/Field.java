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

//    @OneToMany(mappedBy = "field_Id")
//    private List<Crop> crops;

//    @OneToMany(mappedBy = "field_id")
//    private List<Staff> staff;

    @Column(columnDefinition = "LONGTEXT")
    private String fieldImage1;

    @Column(columnDefinition = "LONGTEXT")
    private String fieldImage2;

    @OneToMany(mappedBy = "field")
    private List<FieldCropAssociation> cropAssociations;
    @OneToMany(mappedBy = "field")
    private List<FieldStaffAssociation> staffAssociations;
}
