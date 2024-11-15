package lk.ijse.greenshowspringbootbackend.entity.impl;

import jakarta.persistence.*;
import lk.ijse.greenshowspringbootbackend.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
