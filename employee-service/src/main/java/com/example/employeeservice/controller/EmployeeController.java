package com.example.employeeservice.controller;

import com.example.commonservice.dto.employee.EmployeeDTO;
import com.example.employeeservice.channel.OutputChannel;
import com.example.employeeservice.fiegnClient.BookFeignClient;
import com.example.employeeservice.service.IEmployeeService;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@RestController
@RequestMapping("/api/employee")
@EnableBinding(OutputChannel.class)
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    BookFeignClient bookFeignClient;
    @Autowired
    OutputChannel outputChannel;
    @GetMapping("")
    public String test(){
        return "Employee";
    }
    @GetMapping("/call/book")
    public String testBook(){
        return bookFeignClient.test();
    }
    @GetMapping ("/{employeeId}")
    public ResponseEntity<EmployeeDTO> get(@PathVariable String employeeId){
        return ResponseEntity.ok(employeeService.get(employeeId));
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> update (@PathVariable String employeeId, @RequestBody EmployeeDTO employeeDTO){
        return ResponseEntity.ok(employeeService.update(employeeId, employeeDTO));
    }

    @PostMapping("")
    public ResponseEntity<EmployeeDTO> save (@RequestBody EmployeeDTO employeeDTO){
        return ResponseEntity.ok(employeeService.save(employeeDTO));
    }
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Object> delete (@PathVariable String employeeId){
        employeeService.delete(employeeId);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/notification/email/{email}")
    public String notificationEmail(@PathVariable String email){
        outputChannel.outputEmailNotification().send(MessageBuilder.withPayload(email).build());
        return "Send email successfully !!!";
    }
    @GetMapping("/notification/phone/{phone}")
    public String notificationPhone(@PathVariable String phone){
        outputChannel.outputPhoneNotification().send(MessageBuilder.withPayload(phone).build());
        return "Send phone successfully !!!";
    }
}
