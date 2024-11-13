package lk.ijse.greenshowspringbootbackend.entity.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.geo.Point;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "field")
public class FieldEntity {
    @Id
    private String field_Code;
    private String fieldName;
    private String fieldLocation;
    private Double extendSizeOfTheField;

    @OneToMany(mappedBy = "field")
    private List<CropEntity> Field_Code;

    @OneToMany(mappedBy = "field")
    private List<StaffDetails> fieldCode;

    @OneToMany(mappedBy = "field")
    private List<FieldDetails> field_code;

    private String fieldImage1;
    private String fieldImage2;
}