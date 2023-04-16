package com.example.bookservice.respository;

import com.example.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
}
