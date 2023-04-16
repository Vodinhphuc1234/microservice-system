package com.example.commonservice.dto.auth;

import lombok.Builder;
import lombok.Data;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@Data
@Builder
public class TokenDTO {
    String accessToken;
    String refreshToken;
}
