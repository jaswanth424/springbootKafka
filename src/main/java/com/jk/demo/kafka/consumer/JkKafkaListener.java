package com.jk.demo.kafka.consumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JkKafkaListener {


    @Autowired
    private Environment environment;

    @Value("${spring.kafka.consumer.group-id}")
    private String topic;


    @KafkaListener(topics = "${TOPIC}", groupId = "${spring.kafka.consumer.group-id}")
    public void listener(String message) {
        System.out.println("====== Message from topic :" + topic + "is : " + message);
    }
}
