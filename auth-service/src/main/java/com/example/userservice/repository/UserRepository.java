package com.example.userservice.repository;

import com.example.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
}
