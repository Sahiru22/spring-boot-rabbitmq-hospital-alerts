package com.example.spring_boot_consumer.listner;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class HospitalAlertConsumer {

  @RabbitListener(queues = "admin-alert-queue")
  public void receiveAdminAlert(String message) {
    System.out.println("[Admin Department] received alert: " + message);
  }

  @RabbitListener(queues = "ward-alert-queue")
  public void receiveWardAlert(String message) {
    System.out.println("[Ward Department] received alert: " + message);
  }
}
