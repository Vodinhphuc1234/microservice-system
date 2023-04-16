package com.example.notificationservice;

import com.example.notificationservice.channel.InputChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(InputChannel.class)
@Slf4j
public class NotificationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }
    @StreamListener(InputChannel.INPUT_EMAIL)
    public void processEmail(String email) {
        log.info("Email is received: {}", email);
    }
    @StreamListener(InputChannel.INPUT_PHONE)
    public void processPhone(String phone) {
        log.info("Phone is received: {}", phone);
    }
}
