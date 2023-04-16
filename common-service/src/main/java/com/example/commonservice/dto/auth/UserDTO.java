package com.example.commonservice.dto.auth;

import lombok.Data;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@Data
public class UserDTO {
    String username;
    String password;
    String email;
    String accessToken;
    String refreshToken;
}
