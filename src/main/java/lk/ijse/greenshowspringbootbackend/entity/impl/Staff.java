package lk.ijse.greenshowspringbootbackend.entity.impl;

import jakarta.persistence.*;
import lk.ijse.greenshowspringbootbackend.entity.Gender;
import lk.ijse.greenshowspringbootbackend.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "staff")
public class Staff {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String designation;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date joinedDate;
    private Date dob;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String contactNo;
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "field_code", nullable = false)
    private Field field_id;

    @ManyToMany(mappedBy = "stafList", cascade = {CascadeType.ALL})
    private List<Staff> staffList;

}
