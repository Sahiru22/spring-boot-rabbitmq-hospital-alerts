package com.example.spring_boot_consumer.listner;

import com.example.spring_boot_consumer.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

  @RabbitListener(queues = RabbitMqConfig.DOCTOR_QUEUE)
  public void handleDoctorNotification(String message) {
    System.out.println("Doctor Notification: " + message);
  }

  @RabbitListener(queues = RabbitMqConfig.ADMIN_QUEUE)
  public void handleAdminNotification(String message) {
    System.out.println("Admin Notification: " + message);
  }

  @RabbitListener(queues = RabbitMqConfig.MAINTENANCE_QUEUE)
  public void handleMaintenanceNotification(String message) {
    System.out.println("Maintenance Notification: " + message);
  }
}