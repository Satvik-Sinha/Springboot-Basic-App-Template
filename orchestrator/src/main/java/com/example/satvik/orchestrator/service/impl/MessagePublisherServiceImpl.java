package com.example.satvik.orchestrator.service.impl;

import com.example.satvik.orchestrator.modal.NoSqlTableRequest;
import com.example.satvik.orchestrator.service.MessagePublisherService;
import lombok.AllArgsConstructor;
import lombok.extern.flogger.Flogger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Flogger
@AllArgsConstructor
public class MessagePublisherServiceImpl implements MessagePublisherService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void publishOdsEvent(NoSqlTableRequest noSqlTableRequest, String topicName) {
        try {
            // Generate a key based on rollNo if available, otherwise use a default
            String key = noSqlTableRequest.getRollNo() != null 
                ? String.valueOf(noSqlTableRequest.getRollNo()) 
                : "default-key";
            
            // Send the message to Kafka topic
            CompletableFuture<SendResult<String, Object>> future = 
                kafkaTemplate.send(topicName, key, noSqlTableRequest);
            
            // Add callback to handle success and failure
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    log.atInfo().log("Successfully published message to Kafka topic: %s, partition: %d, offset: %d, key: %s", 
                        topicName, 
                        result.getRecordMetadata().partition(),
                        result.getRecordMetadata().offset(),
                        key);
                } else {
                    log.atSevere().withCause(ex).log("Failed to publish message to Kafka topic: %s, key: %s", 
                        topicName, 
                        key);
                }
            });
            
        } catch (Exception e) {
            log.atSevere().withCause(e).log("Error while publishing message to Kafka topic: %s", topicName);
            throw new RuntimeException("Failed to publish message to Kafka", e);
        }
    }
}
