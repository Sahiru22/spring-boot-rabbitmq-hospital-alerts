package com.example.spring_boot_producer.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class HospitalAlertProducer {

  private static final String FANOUT_EXCHANGE = "hospital-alert-exchange";

  private final RabbitTemplate rabbitTemplate;

  public HospitalAlertProducer(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void sendHospitalAlert(String message) {
    rabbitTemplate.convertAndSend(FANOUT_EXCHANGE, "", message);
    System.out.println("Broadcast hospital alert: " + message);
  }
}
