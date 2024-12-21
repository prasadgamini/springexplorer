package edu.srirama.learn.springexplorer.messaging;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.srirama.learn.springexplorer.entity.Student;
import edu.srirama.learn.springexplorer.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private StudentService studentService;

    @KafkaListener(topics = "${custom.consumer-topic-name}", groupId = "${custom.consumer-group-id}")
    public void consumeMessages(ConsumerRecord<?, Object> event, Acknowledgment acknowledgment) {
        Student student = objectMapper.convertValue(event.value(), Student.class);
        log.info(".KafkaConsumer.consumeMessages. Message Received:{}", student);
        studentService.saveStudent(student);
        acknowledgment.acknowledge();
    }
}
