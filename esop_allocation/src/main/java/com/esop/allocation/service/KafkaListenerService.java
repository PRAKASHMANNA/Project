package com.esop.allocation.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaListenerService {

    private final AllocationService allocationService;

    @KafkaListener(topics = "grant-topic", groupId = "grant-group")
    public void consume(List<Map<String, Object>> grantList) {
        log.info("Received data from Kafka: {}", grantList);
        allocationService.saveAllocations(grantList);
    }
}
