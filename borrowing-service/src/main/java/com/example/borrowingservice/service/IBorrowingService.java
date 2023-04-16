package com.example.borrowingservice.service;


import com.example.commonservice.dto.borrowing.BorrowingDTO;

/**
 * Created by vodinhphuc on 29/03/2023
 */
public interface IBorrowingService {
    BorrowingDTO save (BorrowingDTO borrowingDTO);

    BorrowingDTO update(String borrowingId, BorrowingDTO borrowingDTO);

    void delete(String borrowingId);
    BorrowingDTO get(String borrowingId);
}
