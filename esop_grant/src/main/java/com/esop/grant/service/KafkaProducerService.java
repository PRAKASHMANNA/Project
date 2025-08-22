package com.esop.grant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendGrantToKafka(Object grantData) {
        kafkaTemplate.send("grant-topic", grantData);  
    }
}
