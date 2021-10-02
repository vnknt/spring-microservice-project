package com.ingbootcamp.notificationservice;

import com.ingbootcamp.servicecommon.configs.QueueConfig;
import com.ingbootcamp.servicecommon.contracts.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {
    @RabbitListener(queues = QueueConfig.QUEUE_NAME)
    public void onNotification(Notification notification){
        System.out.println("***************  "+ notification.getTitle()+"  ***************");
        System.out.println("\t\t"+ notification.getTitle());
        System.out.println("_______________________________________________________________-");
    }
}
