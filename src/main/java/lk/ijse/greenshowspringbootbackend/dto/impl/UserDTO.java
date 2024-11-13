package lk.ijse.greenshowspringbootbackend.dto.impl;

import jakarta.persistence.Id;
import lk.ijse.greenshowspringbootbackend.dto.SuperDTO;
import lk.ijse.greenshowspringbootbackend.dto.UserStatus;
import lk.ijse.greenshowspringbootbackend.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements SuperDTO, UserStatus {
    @Id
    private String email;
    private String password;
    private Role role;
}
