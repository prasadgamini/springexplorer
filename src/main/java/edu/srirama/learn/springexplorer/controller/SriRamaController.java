package edu.srirama.learn.springexplorer.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class SriRamaController {

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        log.info("SriRamaController.ping");
        return ResponseEntity.ok("pong");
    }
}
