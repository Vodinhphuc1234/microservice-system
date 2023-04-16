package com.example.userservice.service;

import com.example.commonservice.dto.auth.AuthenticationDTO;
import com.example.commonservice.dto.auth.UserDTO;

/**
 * Created by vodinhphuc on 29/03/2023
 */
public interface IUserService {
    AuthenticationDTO register (UserDTO userDTO);
    AuthenticationDTO login (UserDTO userDTO);
}
