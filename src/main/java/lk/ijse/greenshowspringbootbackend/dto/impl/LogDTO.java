package lk.ijse.greenshowspringbootbackend.dto.impl;

import lk.ijse.greenshowspringbootbackend.dto.LogStatus;
import lk.ijse.greenshowspringbootbackend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LogDTO implements SuperDTO, LogStatus {
    private String logCode;
    private Date logDate;
    private String observationDetails;
    private String observedImage;
    private List<String> relevantFields;
    private List<String> relevantCrops;
    private List<String> relevantStaff;
}
