package com.example.spring_boot_consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitMQConfig {

  public static final String FANOUT_EXCHANGE = "hospital-alert-exchange";
  public static final String ADMIN_QUEUE = "admin-alert-queue";
  public static final String WARD_QUEUE = "ward-alert-queue";

  @Bean
  public FanoutExchange hospitalFanoutExchange() {
    return new FanoutExchange(FANOUT_EXCHANGE);
  }

  @Bean("fanoutAdminQueue")
  public Queue fanoutAdminQueue() {
    return new Queue(ADMIN_QUEUE, true);
  }

  @Bean("fanoutWardQueue")
  public Queue fanoutWardQueue() {
    return new Queue(WARD_QUEUE, true);
  }

  @Bean
  public Binding bindFanoutAdminQueue() {
    return BindingBuilder.bind(fanoutAdminQueue()).to(hospitalFanoutExchange());
  }

  @Bean
  public Binding bindFanoutWardQueue() {
    return BindingBuilder.bind(fanoutWardQueue()).to(hospitalFanoutExchange());
  }
}