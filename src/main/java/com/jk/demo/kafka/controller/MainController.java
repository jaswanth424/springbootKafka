package com.jk.demo.kafka.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class MainController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${TOPIC}")
    private String topic;

    public void sendMessage(String message) {
        String topic = "quickstart-events";
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("sent message");
            } else {
                System.out.println("unable to send message" + ex.getMessage());
            }
        });
    }

    @PostMapping("/publish")
    public void publish(@RequestParam String message) {
        sendMessage(message);
    }
}
