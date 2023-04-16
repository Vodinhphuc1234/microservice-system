package com.example.borrowingservice.respository;

import com.example.borrowingservice.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, UUID> {
}
