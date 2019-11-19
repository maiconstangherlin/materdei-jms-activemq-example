package br.edu.materdei.notafiscal;

import br.edu.materdei.config.ConfigMQ;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerTopicNotaFiscal {

    @JmsListener(destination = ConfigMQ.NOTIFICATION_TOPICO)
    public void consumeTopic(String message) {
        System.out.println("NOTA FISCAL TOPICO RECEBEU MENSAGEM: " + message);
    }
}
