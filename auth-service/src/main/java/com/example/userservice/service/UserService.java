package com.example.userservice.service;

import com.example.commonservice.dto.auth.AuthenticationDTO;
import com.example.commonservice.dto.auth.TokenDTO;
import com.example.commonservice.dto.auth.UserDTO;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.utils.JwtTokenManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@Service
public class UserService implements  IUserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtTokenManager jwtTokenManager;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public AuthenticationDTO register(UserDTO userDTO) {
        //register
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        BeanUtils.copyProperties(user, userDTO);

        //get token
        String accessToken = jwtTokenManager.generateAccessToken(user);
        String refreshToken = jwtTokenManager.generateRefreshToken(user);

        TokenDTO tokenDTO = TokenDTO
                .builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
        return AuthenticationDTO
                .builder()
                .token(tokenDTO)
                .user(userDTO)
                .build();
    }

    @Override
    public AuthenticationDTO login(UserDTO userDTO) {
        //register
        User user =userRepository.findByUsername(userDTO.getUsername());
        if (!passwordEncoder.matches(userDTO.getPassword(), user.getPassword())){
            throw new RuntimeException("Authentication is failed");
        }

        //get token
        String accessToken = jwtTokenManager.generateAccessToken(user);
        String refreshToken = jwtTokenManager.generateRefreshToken(user);

        TokenDTO tokenDTO = TokenDTO
                .builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
        return AuthenticationDTO
                .builder()
                .token(tokenDTO)
                .user(userDTO)
                .build();
    }
}
