package lk.ijse.greenshowspringbootbackend.dto.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import lk.ijse.greenshowspringbootbackend.dto.FieldStatus;
import lk.ijse.greenshowspringbootbackend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldDTO implements SuperDTO, FieldStatus {
    @Id
    private String fieldCode;
    private String name;
    private Point location;
    private double extentSize;
    private String fieldImage1;
    private String fieldImage2;
    @JsonIgnore
    private List<EquipmentDTO> equipmentList;
    @JsonIgnore
    private List<StaffDTO> staffList;
    @JsonIgnore
    private List<LogDTO> logList;
    private List<CropDTO> cropList;
}
