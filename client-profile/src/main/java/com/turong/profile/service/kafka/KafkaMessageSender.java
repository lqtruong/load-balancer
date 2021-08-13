package com.turong.profile.service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageSender<T> {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void send(String topic, T data) {
        Message message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .setHeader("x-tenant-id", "tr")
                .build();
        kafkaTemplate.send(message);
    }

}
