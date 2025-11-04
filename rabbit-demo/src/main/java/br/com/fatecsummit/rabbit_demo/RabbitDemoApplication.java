package br.com.fatecsummit.rabbit_demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitDemoApplication.class, args);
	}

    private static final String FILA = "fanout-queue-2";

    @RabbitListener(queues = FILA)
    public void receberMensagem(String mensagem) {
        System.out.println("Mensagem recebida: " + mensagem);
    }


}
