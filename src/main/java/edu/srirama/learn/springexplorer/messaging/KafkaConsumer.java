package edu.srirama.learn.springexplorer.messaging;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "${custom.consumer-topic-name}", groupId = "${custom.consumer-group-id}")
    public void consumeMessages(ConsumerRecord<?, Object> event, Acknowledgment acknowledgment) {
        log.info(".KafkaConsumer.consumeMessages. Message Received:{}", event.value());
        acknowledgment.acknowledge();
    }
}
