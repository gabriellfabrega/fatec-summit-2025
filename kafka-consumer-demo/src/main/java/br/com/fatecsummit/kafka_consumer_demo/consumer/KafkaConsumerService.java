package br.com.fatecsummit.kafka_consumer_demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "topico-teste", groupId = "demo-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
