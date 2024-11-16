package lk.ijse.greenshowspringbootbackend.dto.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String extentSize;
    private String fieldImage1;
    private String fieldImage2;
}
