package se.iths.f12022statistics.JMS.sender;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import se.iths.f12022statistics.JMS.config.JmsConfig;

@Component
public class Sender {

    private final JmsTemplate jmsTemplate;

    public Sender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }


    public void SendMessage(String message) {
        System.out.println("Sending JMS to ActiveMQ");
        jmsTemplate.convertAndSend(JmsConfig.F12022STATS_QUEUE, message);
    }

}
