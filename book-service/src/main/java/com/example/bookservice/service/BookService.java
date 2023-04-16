package com.example.bookservice.service;

import com.example.bookservice.model.Book;
import com.example.bookservice.respository.BookRepository;
import com.example.commonservice.dto.book.BookDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@Service
public class BookService implements IBookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public BookDTO save(BookDTO bookDTO) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        book = bookRepository.save(book);
        BeanUtils.copyProperties(book, bookDTO);
        return bookDTO;
    }

    @Override
    public BookDTO update(String bookId, BookDTO bookDTO) {
        Book book = bookRepository.findById(UUID.fromString(bookId)).orElse(null);
        if (book == null) {
            throw new RuntimeException("Book is not existing");
        }
        BeanUtils.copyProperties(bookDTO, book);
        book = bookRepository.save(book);
        BeanUtils.copyProperties(book, bookDTO);
        return bookDTO;
    }

    @Override
    public void delete(String bookId) {
        Book book = bookRepository.findById(UUID.fromString(bookId)).orElse(null);
        if (book == null) {
            throw new RuntimeException("Book is not existing");
        }
        bookRepository.delete(book);
    }

    @Override
    public BookDTO get(String bookId) {
        Book book = bookRepository.findById(UUID.fromString(bookId)).orElse(null);
        if (book == null) {
            throw new RuntimeException("Book is not existing");
        }
        BookDTO bookDTO = new BookDTO();
        BeanUtils.copyProperties(book, bookDTO);
        return bookDTO;
    }
}
