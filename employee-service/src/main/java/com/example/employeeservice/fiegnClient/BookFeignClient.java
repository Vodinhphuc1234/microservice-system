package com.example.employeeservice.fiegnClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@FeignClient("book-service")
public interface BookFeignClient {
    @RequestMapping("/api/book")
    String test();
}
