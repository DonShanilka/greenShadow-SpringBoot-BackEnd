package lk.ijse.greenshowspringbootbackend.service;

import lk.ijse.greenshowspringbootbackend.dto.impl.UserDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.VehicleDTO;

import java.util.List;

public interface UserService {
    void save(UserDTO userDTO);
    void update(String userId,UserDTO userDTO);
    void delete(String userId);
    List<UserDTO> getAllVehicles();
}
