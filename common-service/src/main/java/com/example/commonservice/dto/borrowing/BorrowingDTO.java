package com.example.commonservice.dto.borrowing;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@Data
@NoArgsConstructor
public class BorrowingDTO {
    UUID id;
    UUID employeeId;
    UUID bookId;
    long timeBorrowed;
}
