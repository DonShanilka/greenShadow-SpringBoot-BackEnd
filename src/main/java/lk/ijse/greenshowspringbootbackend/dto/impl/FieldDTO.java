package lk.ijse.greenshowspringbootbackend.dto.impl;

import lk.ijse.greenshowspringbootbackend.dto.FieldStatus;
import lk.ijse.greenshowspringbootbackend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldDTO implements SuperDTO, FieldStatus {
    private String fieldCode;
    private String fieldName;
    private String location;
    private double extentSize;
    private List<String> crops;
    private List<String> staff;
    private String fieldImage1;
    private String fieldImage2;
}
