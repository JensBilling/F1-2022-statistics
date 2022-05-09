package se.iths.f12022statistics.JMS.sender;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import se.iths.f12022statistics.JMS.config.JmsConfig;
import se.iths.f12022statistics.JMS.model.MessageObject;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class Sender {

    private final JmsTemplate jmsTemplate;

    public Sender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }


    public void SendMessage(String message){
        System.out.println("Sending JMS to ActiveMQ");

        // Message object not in use
        // MessageObject messageObject = new MessageObject(UUID.randomUUID(), message, LocalDateTime.now());
        jmsTemplate.convertAndSend(JmsConfig.F12022STATS_QUEUE, message);
    }

}
