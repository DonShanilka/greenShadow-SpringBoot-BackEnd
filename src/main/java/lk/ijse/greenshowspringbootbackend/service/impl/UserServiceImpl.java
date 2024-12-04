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
    public void login(String email, String password) {
        // Find user by email
        Optional<User> userOptional = userRepo.findByEmail(email);

        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User not found for email: " + email);
        }
        User user = userOptional.get();
        // Check if password matches
        if (!user.getPassword().equals(password)) {
            throw new UserNotFoundException("Invalid password");
        }
        // If successful, proceed with login logic
        System.out.println("Login successful for email: " + email);
    }

    @Override
    public void update(UserDTO userDTO) {
        if (!userRepo.existsById(userDTO.getEmail())) {
            throw new UserNotFoundException(userDTO.getEmail() + " does not exist");
        }
        userRepo.save(mapping.mapUserDtoToEntity(userDTO));
    }

    @Override
    public void delete(String userId) {
        if (!userRepo.existsById(userId)) {
            throw new UserNotFoundException(userId + " does not exist");
        }
        userRepo.deleteById(userId);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> allUsers = userRepo.findAll();
        return mapping.mapUserEntitiesToDtos(allUsers);
    }
}
