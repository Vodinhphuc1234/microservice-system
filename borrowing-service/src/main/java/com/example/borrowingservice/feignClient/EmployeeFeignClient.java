package com.example.borrowingservice.feignClient;

import com.example.borrowingservice.dto.EmployeeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@FeignClient("employee-service")
public interface EmployeeFeignClient {
    @RequestMapping("/api/employee/{employeeId}")
    ResponseEntity<EmployeeDTO> getEmployee (@PathVariable String employeeId);
}
