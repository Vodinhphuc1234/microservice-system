package com.example.userservice.controller;


import com.example.commonservice.dto.auth.AuthenticationDTO;
import com.example.commonservice.dto.auth.UserDTO;
import com.example.userservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    IUserService userService;
    @PostMapping("/login")
    public ResponseEntity<AuthenticationDTO> register (@RequestBody UserDTO userDTO){
        AuthenticationDTO authenticationDTO = userService.register(userDTO);
        return ResponseEntity.ok(authenticationDTO);
    }
    @GetMapping("")
    public String test(){
        return "Authentication";
    }
    @PostMapping("/register")
    public ResponseEntity<AuthenticationDTO> login (@RequestBody UserDTO userDTO){
        AuthenticationDTO authenticationDTO = userService.register(userDTO);
        return ResponseEntity.ok(authenticationDTO);
    }
}
