package com.example.notificationservice.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by vodinhphuc on 30/03/2023
 */
public interface OutputChannel {
    String OUTPUT = "OUTPUT";
    @Output(OUTPUT)
    MessageChannel myOutput();
}
