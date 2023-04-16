package com.example.employeeservice.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by vodinhphuc on 30/03/2023
 */
public interface OutputChannel {
    String OUTPUT_EMAIL_NOTIFICATION = "OUTPUT_EMAIL_NOTIFICATION";
    String OUTPUT_PHONE_NOTIFICATION = "OUTPUT_PHONE_NOTIFICATION";
    @Output(OUTPUT_EMAIL_NOTIFICATION)
    MessageChannel outputEmailNotification();
    @Output(OUTPUT_PHONE_NOTIFICATION)
    MessageChannel outputPhoneNotification();
}
