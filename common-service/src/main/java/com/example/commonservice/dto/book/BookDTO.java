package com.example.commonservice.dto.book;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@Data
@NoArgsConstructor
public class BookDTO {
    String name;
    String author;
    long timeImported;
}
