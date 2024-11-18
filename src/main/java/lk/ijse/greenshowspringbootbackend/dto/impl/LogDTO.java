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
    private Date logDate;
    private String observationDetails;
    private String image;
    private List<FieldDTO> relevantFields;
    private List<CropDTO> relevantCrops;
    private List<StaffDTO> relevantStaff;
}
