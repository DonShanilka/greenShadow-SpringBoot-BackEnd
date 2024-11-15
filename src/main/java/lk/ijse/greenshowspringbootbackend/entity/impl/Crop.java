package lk.ijse.greenshowspringbootbackend.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "crop")
public class Crop {
    @Id
    private String cropCode;
    private String cropName;
    private String scientificName;
    @Column(columnDefinition = "LONGTEXT")
    private String image;
    private String category;
    private String season;

    @ManyToOne
    @JoinColumn(name = "field_code", nullable = false)
    private Field field_Id;
}
