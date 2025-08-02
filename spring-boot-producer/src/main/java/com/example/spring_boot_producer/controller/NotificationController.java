package com.example.spring_boot_producer.controller;

import com.example.spring_boot_producer.producer.NotificationProducer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify")
@AllArgsConstructor
public class NotificationController {

  private final NotificationProducer producer;

  @GetMapping("/doctor")
  public void notifyDoctor(@RequestParam String message) {
    producer.sendNotification("doctor.notify", message);
  }

  @GetMapping("/admin")
  public void notifyAdmin(@RequestParam String message) {
    producer.sendNotification("admin.notify", message);
  }

  @GetMapping("/maintenance")
  public void notifyMaintenance(@RequestParam String message) {
    producer.sendNotification("maintenance.notify", message);
  }
}
