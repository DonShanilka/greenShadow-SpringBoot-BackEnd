package lk.ijse.greenshowspringbootbackend.dto.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import lk.ijse.greenshowspringbootbackend.dto.CropStatus;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CropDTO implements CropStatus {
    @Id
    private String cropCode;
    private String cropName;
    private String scientificName;
    private String category;
    private String season;
    private String cropImage;
    @JsonIgnore
    private List<LogDTO> logList;
    @JsonIgnore
    private List<FieldDTO> fieldList;

    public void getCropCode(String s) {
        this.cropCode = s;
    }
}
