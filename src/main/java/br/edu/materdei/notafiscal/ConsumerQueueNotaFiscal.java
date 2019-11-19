package br.edu.materdei.notafiscal;

import br.edu.materdei.config.ConfigMQ;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerQueueNotaFiscal {

    @JmsListener(destination = ConfigMQ.NOTIFICATION_FILA)
    public void consumeQueue(String message) {
        System.out.println("NOTA FISCAL FILA RECEBEU MENSAGEM: " + message);
    }

}
