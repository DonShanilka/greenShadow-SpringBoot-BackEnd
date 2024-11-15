package lk.ijse.greenshowspringbootbackend.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CropDTO {
    private String cropCode;
    private String cropName;
    private String scientificName;
    private String image;
    private String category;
    private String season;
}
