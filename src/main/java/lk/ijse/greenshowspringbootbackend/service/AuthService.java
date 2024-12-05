package lk.ijse.greenshowspringbootbackend.service;


import lk.ijse.greenshowspringbootbackend.dto.impl.UserDTO;
import lk.ijse.greenshowspringbootbackend.secure.JWTAuthResponse;
import lk.ijse.greenshowspringbootbackend.secure.SignIn;

public interface AuthService {
    JWTAuthResponse signIn(SignIn signIn);
    JWTAuthResponse signUp(UserDTO userDTO);
    JWTAuthResponse refreshToken(String refreshToken);
}
