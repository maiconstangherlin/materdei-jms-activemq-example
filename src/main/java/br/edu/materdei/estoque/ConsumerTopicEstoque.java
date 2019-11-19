package br.edu.materdei.estoque;

import br.edu.materdei.config.ConfigMQ;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerTopicEstoque {

    @JmsListener(destination = ConfigMQ.NOTIFICATION_TOPICO)
    public void consumeTopic(String message) {
        System.out.println("ESTOQUE TOPICO RECEBEU MENSAGEM: " + message);
    }
}
