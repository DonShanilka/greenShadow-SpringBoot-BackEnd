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
    private String category;
    private String season;
    @Column(columnDefinition = "LONGTEXT")
    private String cropImage;
    @JsonIgnore
    @ManyToMany(mappedBy = "cropList")
    private List<LogEntity> longLis;
    @JsonIgnore
    @ManyToMany(mappedBy = "cropList")
    private List<FieldEntity> fieldList;
}
