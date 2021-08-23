package com.turong.mail.service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMailingListener {

    @KafkaListener(
            topics = "profile-creation-sendmail",
            groupId = "profile-creation-sendmail-group",
            containerFactory = "sendMailMessageKafkaFactory"
    )
    public void listenMailingProfile(@Payload MailingProfile mailingProfile, @Headers MessageHeaders headers) {
        log.info("Kafka listenMailingProfile => mailingProfile={}", mailingProfile);
        log.info("Kafka listenMailingProfile => headers={}", headers);
    }


}
