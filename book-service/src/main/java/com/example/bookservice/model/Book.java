package com.example.bookservice.model;

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
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="uuid-char")
    @Column(name="id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    UUID id;
    String name;
    String author;
    long timeImported;

    @PrePersist
    public void initTimeImported(){
        this.timeImported = System.currentTimeMillis();
    }
}
