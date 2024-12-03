package lk.ijse.greenshowspringbootbackend.dto.impl;

import lk.ijse.greenshowspringbootbackend.dto.CropStatus;
import lk.ijse.greenshowspringbootbackend.dto.SuperDTO;
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
    private String cropImage;
    private String category;
    private String season;
    private String fieldCode;

    public CropDTO(String cropName, String scientificName, String imageBase64, String category, String season, String fieldCode) {
        this.cropName = cropName;
        this.scientificName = scientificName;
        this.cropImage = imageBase64;
        this.category = category;
        this.season = season;
        this.fieldCode = fieldCode;
    }
}
