package com.example.employeeservice.repository;

import com.example.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, UUID> {
}
