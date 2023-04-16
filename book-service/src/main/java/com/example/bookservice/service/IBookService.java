package com.example.bookservice.service;

import com.example.commonservice.dto.book.BookDTO;

/**
 * Created by vodinhphuc on 29/03/2023
 */
public interface IBookService {
    BookDTO save (BookDTO bookDTO);

    BookDTO update(String bookId, BookDTO bookDTO);

    void delete(String bookId);
    BookDTO get(String bookId);
}
