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
    private String observedImage;
    private List<String> relevantFields;
    private List<String> relevantCrops;
    private List<String> relevantStaff;
}
