package com.example.employeeservice.service;

import com.example.commonservice.dto.employee.EmployeeDTO;
import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        employee = employeeRepository.save(employee);
        BeanUtils.copyProperties(employee, employeeDTO);
        return employeeDTO;
    }

    @Override
    public EmployeeDTO update(String employeeId, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(UUID.fromString(employeeId)).orElse(null);
        if (employee == null) {
            throw new RuntimeException("Employee is not existing");
        }
        BeanUtils.copyProperties(employeeDTO, employee);
        employee = employeeRepository.save(employee);
        BeanUtils.copyProperties(employee, employeeDTO);
        return employeeDTO;
    }

    @Override
    public void delete(String bookId) {
        Employee employee = employeeRepository.findById(UUID.fromString(bookId)).orElse(null);
        if (employee == null) {
            throw new RuntimeException("Employee is not existing");
        }
        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeDTO get(String employeeId) {
        Employee employee = employeeRepository.findById(UUID.fromString(employeeId)).orElse(null);
        if (employee == null) {
            throw new RuntimeException("Employee is not existing");
        }
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employeeDTO, employeeDTO);
        return employeeDTO;
    }
}
