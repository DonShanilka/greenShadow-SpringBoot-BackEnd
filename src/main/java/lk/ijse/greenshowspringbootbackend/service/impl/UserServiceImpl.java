package lk.ijse.greenshowspringbootbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.greenshowspringbootbackend.dto.impl.UserDTO;
import lk.ijse.greenshowspringbootbackend.entity.Role;
import lk.ijse.greenshowspringbootbackend.entity.impl.User;
import lk.ijse.greenshowspringbootbackend.exception.DataPersistException;
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
    public void update(String userId, UserDTO userDTO) {
        Optional<User> user = userRepo.findById(userId);
        if (user.isPresent()) {
            user.get().setPassword(userDTO.getPassword());
            user.get().setRole(Role.valueOf(userDTO.getRole()));
        }
    }

    @Override
    public void delete(String userId) {

    }

    @Override
    public List<UserDTO> getAllVehicles() {
        return List.of();
    }
}
