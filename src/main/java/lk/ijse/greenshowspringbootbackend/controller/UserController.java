package lk.ijse.greenshowspringbootbackend.controller;

import lk.ijse.greenshowspringbootbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;


}
