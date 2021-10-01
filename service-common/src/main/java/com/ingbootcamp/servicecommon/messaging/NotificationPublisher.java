package com.ingbootcamp.servicecommon.messaging;


import com.ingbootcamp.servicecommon.configs.QueueConfig;
import com.ingbootcamp.servicecommon.contracts.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class NotificationPublisher {
    @Autowired
    private RabbitTemplate template;



    public void sendNotification(Notification notification){
        template.convertAndSend(
                QueueConfig.TOPIC_EXCHANGE,
                QueueConfig.ROUTING_KEY,
                notification.toString()
        );
    }


}
