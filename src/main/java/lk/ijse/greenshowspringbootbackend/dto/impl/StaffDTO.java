package lk.ijse.greenshowspringbootbackend.dto.impl;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.ijse.greenshowspringbootbackend.dto.LogStatus;
import lk.ijse.greenshowspringbootbackend.dto.SuperDTO;
import lk.ijse.greenshowspringbootbackend.entity.Gender;
import lk.ijse.greenshowspringbootbackend.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDTO implements SuperDTO , LogStatus {
    private String id;
    private String firstName;
    private String lastName;
    private String designation;
    private Gender gender;
    private Date joinedDate;
    private Date dob;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String contactNo;
    private String email;
    private Role role;
}
