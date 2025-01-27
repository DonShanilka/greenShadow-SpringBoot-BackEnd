package lk.ijse.greenshowspringbootbackend.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LogDTO {
    private String logCode;
    private String logDate;
    private String logDetails;
    private String image;
    private List<FieldDTO> relevantFields;
    private List<CropDTO> relevantCrops;
    private List<StaffDTO> relevantStaff;

    public LogDTO(String date, String details, String imageBase64, List<FieldDTO> fieldDTOS, List<CropDTO> cropDTOS, List<StaffDTO> staffDTOS) {
        this.logDate = date;
        this.logDetails = details;
        this.image = imageBase64;
        this.relevantFields = fieldDTOS;
        this.relevantCrops = cropDTOS;
        this.relevantStaff = staffDTOS;
    }

    public LogDTO(String date, String details, String imageBase64) {
        this.logDate = date;
        this.logDetails = details;
        this.image = imageBase64;
    }

    public LogDTO(String logCode, String logDate, String logDetails, String base64proPic1) {
        this.logCode = logCode;
        this.logDate = logDate;
        this.logDetails = logDetails;
        this.image = base64proPic1;
    }
}
