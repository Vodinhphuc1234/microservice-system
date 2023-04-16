package com.example.commonservice.dto.employee;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@Data
@NoArgsConstructor
public class EmployeeDTO {
    String fullName;
    String userId;
    long dob;
    long timeJoined;
}
