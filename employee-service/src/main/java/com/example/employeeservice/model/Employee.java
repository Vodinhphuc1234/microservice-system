package com.example.employeeservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@Data
@NoArgsConstructor
@Table
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="uuid-char")
    @Column(name="id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    UUID id;
    String fullName;
    String userId;
    long dob;
    long timeJoined;
    @PrePersist
    public void initTimeJoined(){
        this.timeJoined = System.currentTimeMillis();
    }
}
