package lk.ijse.greenshowspringbootbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.greenshowspringbootbackend.customStatusCode.SelectedErrorStatus;
import lk.ijse.greenshowspringbootbackend.dto.impl.UserDTO;
import lk.ijse.greenshowspringbootbackend.dto.status.Status;
import lk.ijse.greenshowspringbootbackend.entity.impl.User;
import lk.ijse.greenshowspringbootbackend.exception.DataPersistException;
import lk.ijse.greenshowspringbootbackend.exception.UserNotFoundException;
import lk.ijse.greenshowspringbootbackend.repo.UserRepo;
import lk.ijse.greenshowspringbootbackend.service.UserService;
import lk.ijse.greenshowspringbootbackend.util.AppUtil;
import lk.ijse.greenshowspringbootbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    public void saveUser(UserDTO UserDto) {
        User savedUser =
                userRepo.save(mapping.mapUserDtoToEntity(UserDto));
        if (savedUser == null) {
            throw new DataPersistException("");
        }
    }

    @Override
    public List<UserDTO> getUserList() {
        List<User> allUsers = userRepo.findAll();
        return mapping.mapUserEntitiesToDtos(allUsers);
    }

    @Override
    public Status getUserById(String userId) {
        if (userRepo.existsById(userId)) {
            User selectedUser = userRepo.getReferenceById(userId);
            return mapping.toUserDTO(selectedUser);
        }else {
            return new SelectedErrorStatus(2,"user not found");
        }
    }

    @Override
    public void updateUser(String userId, UserDTO userDto) {

    }

    @Override
    public void deleteUser(String userId) {
        Optional<User> existedUser = userRepo.findById(userId);
        if(!existedUser.isPresent()){
            throw new UserNotFoundException("User with id " + userId + " not found");
        }else {
            userRepo.deleteById(userId);
        }
    }

    @Override
    public UserDetailsService userDetailsService() {
        return  userName -> userRepo.findByEmail(userName)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
