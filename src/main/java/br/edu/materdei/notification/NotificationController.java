package br.edu.materdei.notification;

import br.edu.materdei.config.ConfigMQ;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

@RestController
@RequestMapping("/notafiscal")
public class NotificationController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/fila/{message}")
    public String fila(@PathVariable("message") String message) {
        Queue queue = new ActiveMQQueue(ConfigMQ.NOTIFICATION_FILA);
        jmsTemplate.convertAndSend(queue, message);
        return "OK!";
    }

    @GetMapping("/topico/{message}")
    public String topico(@PathVariable("message") String message) {
        Topic topic = new ActiveMQTopic(ConfigMQ.NOTIFICATION_TOPICO);
        jmsTemplate.convertAndSend(topic, message);
        return "OK!";
    }

}
