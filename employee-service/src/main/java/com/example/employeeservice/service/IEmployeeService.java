package com.example.employeeservice.service;

import com.example.commonservice.dto.employee.EmployeeDTO;

/**
 * Created by vodinhphuc on 29/03/2023
 */
public interface IEmployeeService {
    EmployeeDTO save (EmployeeDTO employeeDTO);

    EmployeeDTO update(String employeeId, EmployeeDTO employeeDTO);

    void delete(String employeeId);
    EmployeeDTO get(String employeeId);
}
