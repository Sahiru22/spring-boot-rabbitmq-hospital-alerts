package com.example.spring_boot_producer.controller;

import com.example.spring_boot_producer.producer.HospitalAlertProducer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alert")
@AllArgsConstructor
public class HospitalAlertController {

  private final HospitalAlertProducer producer;

  @GetMapping("/send")
  public String sendAlert(@RequestParam String message) {
    producer.sendHospitalAlert(message);
    return "Alert Sent: " + message;
  }
}