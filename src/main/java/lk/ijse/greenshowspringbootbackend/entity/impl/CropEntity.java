package lk.ijse.greenshowspringbootbackend.entity.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lk.ijse.greenshowspringbootbackend.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "crop")
public class CropEntity implements SuperEntity {
    @Id
    private String cropCode;
    private String cropName;
    private String scientificName;
    private String cropImage;
    private String category;
    private String season;

    @ManyToOne
    @JoinColumn(name = "Field_Code",nullable = false)
    private FieldEntity field;
}
