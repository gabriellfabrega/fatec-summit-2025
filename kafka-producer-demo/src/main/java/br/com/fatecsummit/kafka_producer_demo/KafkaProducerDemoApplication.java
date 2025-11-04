package br.com.fatecsummit.kafka_producer_demo;

import br.com.fatecsummit.kafka_producer_demo.producer.KafkaProducerService;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class KafkaProducerDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(KafkaProducerDemoApplication.class, args);

        Map<String, Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9091"); // corrigi o broker
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        ProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<>(configs);
        KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(producerFactory);

        KafkaProducerService producerService = new KafkaProducerService(kafkaTemplate);

        Scanner scanner = new Scanner(System.in); // criar uma vez só

        while (true) {
            System.out.print("Digite o tópico: ");
            String topic = scanner.nextLine();

            System.out.print("Digite a mensagem: ");
            String message = scanner.nextLine();

            producerService.sendMessage(topic, message);
            System.out.println("Mensagem enviada!\n");
        }
    }
}
