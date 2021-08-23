package com.turong.mail.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {

    @Value("${spring.kafka.consumer.bootstrap-servers:}")
    private String kafkaBootstrapServers;

    @Bean("sendMailMessageKafkaFactory")
    KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Integer, String>> sendMailMessageKafkaFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(1);
        factory.setBatchListener(true);
        factory.getContainerProperties().setPollTimeout(3000);
        return factory;
    }

    private ConsumerFactory<Integer, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    private Map<String, Object> consumerConfigs() {
        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServers);
        stringObjectMap.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 500);
        stringObjectMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        stringObjectMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 1000);
        stringObjectMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 30000);
        stringObjectMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        stringObjectMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        stringObjectMap.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        stringObjectMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return stringObjectMap;
    }

}
