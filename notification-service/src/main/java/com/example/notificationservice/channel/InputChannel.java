package com.example.notificationservice.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by vodinhphuc on 30/03/2023
 */
public interface InputChannel {
    String INPUT_EMAIL = "INPUT_EMAIL";
    String INPUT_PHONE = "INPUT_PHONE";
    @Input(INPUT_EMAIL)
    SubscribableChannel inputEmail();
    @Input(INPUT_PHONE)
    SubscribableChannel inputPhone();
}
