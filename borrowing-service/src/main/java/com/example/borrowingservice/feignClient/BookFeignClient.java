package com.example.borrowingservice.feignClient;

import com.example.borrowingservice.dto.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@FeignClient("book-service")
public interface BookFeignClient {
    @RequestMapping("/api/book/{bookId}")
    ResponseEntity<BookDTO> getBook (@PathVariable String bookId);
}
