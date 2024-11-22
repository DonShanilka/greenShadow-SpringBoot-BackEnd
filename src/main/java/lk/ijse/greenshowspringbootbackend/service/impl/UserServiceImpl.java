package lk.ijse.greenshowspringbootbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.greenshowspringbootbackend.dto.impl.UserDTO;
import lk.ijse.greenshowspringbootbackend.entity.impl.User;
import lk.ijse.greenshowspringbootbackend.repo.UserRepo;
import lk.ijse.greenshowspringbootbackend.service.UserService;
import lk.ijse.greenshowspringbootbackend.util.AppUtil;
import lk.ijse.greenshowspringbootbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        User saveUser = userRepo.save(mapping.)
    }

    @Override
    public void update(UserDTO userDTO) {

    }

    @Override
    public void delete(String userId) {

    }

    @Override
    public List<UserDTO> getAllVehicles() {
        return List.of();
    }
}
