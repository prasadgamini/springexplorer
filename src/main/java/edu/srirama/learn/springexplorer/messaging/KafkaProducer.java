package edu.srirama.learn.springexplorer.messaging;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaProducer {

    private KafkaTemplate<String, Object> kafkaTemplate;

    public void publishMessage(String topic, Object message) {
        try {
            CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, LocalDateTime.now().toString(), message);
            SendResult<String, Object> sendResult = future.get();
            log.info(".KafkaProducer.publish Message successful: {}", sendResult.toString());
        } catch (InterruptedException | ExecutionException e) {
            log.error(".KafkaProducer.Exception while publishing message", e);
            throw new RuntimeException(e);
        }
    }


}
