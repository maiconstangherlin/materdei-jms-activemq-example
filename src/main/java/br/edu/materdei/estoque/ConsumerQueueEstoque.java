package br.edu.materdei.estoque;

import br.edu.materdei.config.ConfigMQ;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerQueueEstoque {

    @JmsListener(destination = ConfigMQ.NOTIFICATION_FILA)
    public void consumeQueue(String message) {
        System.out.println("ESTOQUE FILA RECEBEU MENSAGEM: " + message);
    }

}
