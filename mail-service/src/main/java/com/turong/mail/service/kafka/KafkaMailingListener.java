package com.turong.mail.service.kafka;

import com.turong.mail.config.TenantTopicProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMailingListener {

    @Autowired
    private TenantTopicProvider tenantTopicProvider;

    @KafkaListener(
            topics = "#{tenantTopicProvider.getSendMailListeningTopic()}",
            groupId = "cloudufo-group-message-sendmail",
            containerFactory = "sendMailMessageKafkaFactory"
    )
    public void listenMailingProfile(@Payload MailingProfile mailingProfile, @Headers MessageHeaders headers) {
        log.info("Kafka listenMailingProfile => mailingProfile={}", mailingProfile);
        log.info("Kafka listenMailingProfile => headers={}", headers);
    }


}
