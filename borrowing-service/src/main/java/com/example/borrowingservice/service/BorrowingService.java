package com.example.borrowingservice.service;

import com.example.borrowingservice.model.Borrowing;
import com.example.borrowingservice.respository.BorrowingRepository;
import com.example.commonservice.dto.borrowing.BorrowingDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@Service
public class BorrowingService implements IBorrowingService {
    @Autowired
    BorrowingRepository borrowingRepository;

    @Override
    public BorrowingDTO save(BorrowingDTO borrowingDTO) {
        Borrowing borrowing = new Borrowing();
        BeanUtils.copyProperties(borrowingDTO, borrowing);
        borrowing = borrowingRepository.save(borrowing);
        BeanUtils.copyProperties(borrowing, borrowingDTO);
        return borrowingDTO;
    }

    @Override
    public BorrowingDTO update(String bookId, BorrowingDTO borrowingDTO) {
        Borrowing borrowing = borrowingRepository.findById(UUID.fromString(bookId)).orElse(null);
        if (borrowing == null) {
            throw new RuntimeException("Borrowing is not existing");
        }
        BeanUtils.copyProperties(borrowingDTO, borrowing);
        borrowing = borrowingRepository.save(borrowing);
        BeanUtils.copyProperties(borrowing, borrowingDTO);
        return borrowingDTO;
    }

    @Override
    public void delete(String borrowingId) {
        Borrowing borrowing = borrowingRepository.findById(UUID.fromString(borrowingId)).orElse(null);
        if (borrowing == null) {
            throw new RuntimeException("Borrowing is not existing");
        }
        borrowingRepository.delete(borrowing);
    }

    @Override
    public BorrowingDTO get(String borrowingId) {
        Borrowing borrowing = borrowingRepository.findById(UUID.fromString(borrowingId)).orElse(null);
        if (borrowing == null) {
            throw new RuntimeException("Borrowing is not existing");
        }
        BorrowingDTO borrowingDTO = new BorrowingDTO();
        BeanUtils.copyProperties(borrowing, borrowingDTO);
        return borrowingDTO;
    }
}
