package lk.ijse.greenshowspringbootbackend.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldDTO {
    private String fieldCode;
    private String fieldName;
    private String location;
    private String extentSize;
    private String fieldImage1;
    private String fieldImage2;

    public FieldDTO(String fieldName, String location, String extentSize, String base64proPic1, String base64proPic2) {
        this.fieldName = fieldName;
        this.location = location;
        this.extentSize = extentSize;
        this.fieldImage1 = base64proPic1;
        this.fieldImage2 = base64proPic2;
    }
}
