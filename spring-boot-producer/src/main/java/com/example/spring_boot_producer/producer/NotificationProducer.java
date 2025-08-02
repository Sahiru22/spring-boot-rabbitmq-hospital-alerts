package com.example.spring_boot_producer.producer;

import com.example.spring_boot_producer.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

  private final RabbitTemplate rabbitTemplate;

  public NotificationProducer(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void sendNotification(String routingKey, String message) {
    rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, routingKey, message);
    System.out.println("Sent [" + routingKey + "] : " + message);
  }
}