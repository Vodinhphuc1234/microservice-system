package com.example.borrowingservice.controller;

import com.example.borrowingservice.service.IBorrowingService;
import com.example.commonservice.dto.borrowing.BorrowingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@RestController
@RequestMapping("/api/borrowing")
public class BorrowingController {
    @Autowired
    IBorrowingService borrowingService;
    @GetMapping ("")
    public String test(){
        return "Borrowing";
    }
    @GetMapping ("/{borrowingId}")
    public ResponseEntity<BorrowingDTO> get(@PathVariable String borrowingId){
        return ResponseEntity.ok(borrowingService.get(borrowingId));
    }
    @PutMapping("/{borrowingId}")
    public ResponseEntity<BorrowingDTO> update (@PathVariable String borrowingId, @RequestBody BorrowingDTO borrowingDTO){
        return ResponseEntity.ok(borrowingService.update(borrowingId, borrowingDTO));
    }
    @PostMapping("")
    public ResponseEntity<BorrowingDTO> save (@RequestBody BorrowingDTO bookDTO){
        return ResponseEntity.ok(borrowingService.save(bookDTO));
    }
    @DeleteMapping("/{borrowingId}")
    public ResponseEntity<Object> delete (@PathVariable String borrowingId){
        borrowingService.delete(borrowingId);
        return ResponseEntity.ok(null);
    }

}
