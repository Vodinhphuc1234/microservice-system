package com.example.bookservice.controller;

import com.example.bookservice.service.IBookService;
import com.example.commonservice.dto.book.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    IBookService bookService;
    @GetMapping ("")
    public String test(){
        return "Book";
    }
    @GetMapping ("/{bookId}")
    public ResponseEntity<BookDTO> get(@PathVariable String bookId){
        return ResponseEntity.ok(bookService.get(bookId));
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BookDTO> update (@PathVariable String bookId, @RequestBody BookDTO bookDTO){
        return ResponseEntity.ok(bookService.update(bookId, bookDTO));
    }

    @PostMapping("")
    public ResponseEntity<BookDTO> save (@RequestBody BookDTO bookDTO){
        return ResponseEntity.ok(bookService.save(bookDTO));
    }
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Object> delete (@PathVariable String bookId){
        bookService.delete(bookId);
        return ResponseEntity.ok(null);
    }

}
