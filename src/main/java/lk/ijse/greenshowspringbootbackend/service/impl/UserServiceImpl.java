package lk.ijse.greenshowspringbootbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.greenshowspringbootbackend.dto.impl.UserDTO;
import lk.ijse.greenshowspringbootbackend.entity.Role;
import lk.ijse.greenshowspringbootbackend.entity.impl.User;
import lk.ijse.greenshowspringbootbackend.exception.DataPersistException;
import lk.ijse.greenshowspringbootbackend.exception.StaffNotFoundException;
import lk.ijse.greenshowspringbootbackend.exception.UserNotFoundException;
import lk.ijse.greenshowspringbootbackend.exception.VehicleNotFoundException;
import lk.ijse.greenshowspringbootbackend.repo.UserRepo;
import lk.ijse.greenshowspringbootbackend.service.UserService;
import lk.ijse.greenshowspringbootbackend.util.AppUtil;
import lk.ijse.greenshowspringbootbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private Mapping mapping;
    @Autowired
    private AppUtil appUtil;

    @Override
    public void save(UserDTO userDTO) {
        User saveUser = userRepo.save(mapping.mapUserDtoToEntity(userDTO));
        if (saveUser == null) {
            throw new DataPersistException("Save User Failed");
        }
    }

    @Override
    public void update(UserDTO userDTO) {
        if (!userRepo.existsById(userDTO.getEmail())) {
            throw new VehicleNotFoundException(userDTO.getEmail() + " does not exist");
        }
        userRepo.save(mapping.mapUserDtoToEntity(userDTO));
    }

    @Override
    public void delete(String userId) {
        Optional<User> existUser = userRepo.findById(userId);
        if (existUser.isPresent()) {
            throw new UserNotFoundException(userId + " User Not Found");
        } else {
            userRepo.deleteById(userId);
        }
    }

    @Override
    public List<UserDTO> getAllVehicles() {
        List<User> allUsers = userRepo.findAll();
        return mapping.mapUserEntitiesToDtos(allUsers);
    }
}
