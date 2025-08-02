package com.example.spring_boot_producer.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

  public static final String EXCHANGE_NAME = "hospital.notifications";

  @Bean
  public DirectExchange directExchange() {
    return new DirectExchange(EXCHANGE_NAME);
  }
}