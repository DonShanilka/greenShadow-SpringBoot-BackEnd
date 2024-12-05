package lk.ijse.greenshowspringbootbackend.service;

import lk.ijse.greenshowspringbootbackend.dto.impl.UserDTO;
import lk.ijse.greenshowspringbootbackend.dto.status.Status;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO UserDto);
    List<UserDTO> getUserList();
    Status getUserById(String userId);
    void updateUser(String userId, UserDTO userDto);
    void deleteUser(String userId);

    UserDetailsService userDetailsService();
}
