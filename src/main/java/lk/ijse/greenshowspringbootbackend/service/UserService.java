package lk.ijse.greenshowspringbootbackend.service;

import lk.ijse.greenshowspringbootbackend.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    void save(UserDTO userDTO);
    void update(UserDTO userDTO);
    void delete(String userId);
    List<UserDTO> getAllUsers();
}
