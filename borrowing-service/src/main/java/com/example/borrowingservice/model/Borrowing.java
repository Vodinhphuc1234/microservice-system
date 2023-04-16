package com.example.borrowingservice.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@Table
@Entity
@Data
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="uuid-char")
    @Column(columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    UUID id;
    @Column(columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    UUID employeeId;
    @Column(columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    UUID bookId;
    long timeBorrowed;

    @PrePersist
    public void initTime(){
        this.timeBorrowed = System.currentTimeMillis();
    }
}
