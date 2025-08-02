package com.example.spring_boot_consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

  public static final String EXCHANGE_NAME = "hospital.notifications";
  public static final String DOCTOR_QUEUE = "doctor-queue";
  public static final String ADMIN_QUEUE = "admin-queue";
  public static final String MAINTENANCE_QUEUE = "maintenance-queue";

  @Bean
  public DirectExchange directExchange() {
    return new DirectExchange(EXCHANGE_NAME);
  }

  @Bean
  public Queue doctorQueue() {
    return new Queue(DOCTOR_QUEUE, true);
  }

  @Bean
  public Queue adminQueue() {
    return new Queue(ADMIN_QUEUE, true);
  }

  @Bean
  public Queue maintenanceQueue() {
    return new Queue(MAINTENANCE_QUEUE, true);
  }

  @Bean
  public Binding doctorBinding() {
    return BindingBuilder.bind(doctorQueue()).to(directExchange()).with("doctor.notify");
  }

  @Bean
  public Binding adminBinding() {
    return BindingBuilder.bind(adminQueue()).to(directExchange()).with("admin.notify");
  }

  @Bean
  public Binding maintenanceBinding() {
    return BindingBuilder.bind(maintenanceQueue()).to(directExchange()).with("maintenance.notify");
  }
}