package edu.srirama.learn.springexplorer.controller;


import edu.srirama.learn.springexplorer.messaging.KafkaProducer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/kafka-publish")
@AllArgsConstructor
public class KafkaPublishController {

    private KafkaProducer kafkaProducer;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        log.info("SriRamaController.ping");
        return ResponseEntity.ok("pong");
    }


    @PostMapping("/{topic}")
    public ResponseEntity<String> publishMessage(@PathVariable String topic,
                                                 @RequestBody Object message) {

        kafkaProducer.publishMessage(topic, message);
        return ResponseEntity.ok("SUCCESS");
    }
}
