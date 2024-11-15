package lk.ijse.greenshowspringbootbackend.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    private double extentSize;
    @OneToMany(mappedBy = "field")
    private List<FieldCropAssociation> crops;
    @OneToMany(mappedBy = "field")
    private List<FieldStaffAssociation> staff;
    private String fieldImage1;
    private String fieldImage2;
}
