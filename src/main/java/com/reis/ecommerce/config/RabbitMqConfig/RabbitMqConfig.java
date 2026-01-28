package com.reis.ecommerce.config.RabbitMqConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConfig
{
  public static final String EXCHANGE = "ecommerce.exchange";

  public static final String ORDER_CREATED_QUEUE = "order.created.queue";
  public static final String PAYMENT_COMPLETED_QUEUE = "payment.completed.queue";

  @Bean
  public TopicExchange ecommerceExchange() {
    return new TopicExchange(EXCHANGE);
  }

  @Bean
  public Queue orderCreatedQueue() {
    return new Queue(ORDER_CREATED_QUEUE, true);
  }

  @Bean
  public Queue paymentCompletedQueue() {
    return new Queue(PAYMENT_COMPLETED_QUEUE, true);
  }

  @Bean
  public Binding orderCreatedBinding(
      Queue orderCreatedQueue,
      TopicExchange ecommerceExchange) {

    return BindingBuilder.bind(orderCreatedQueue)
        .to(ecommerceExchange)
        .with("order.created");
  }

  @Bean
  public Binding paymentCompletedBinding(
      Queue paymentCompletedQueue,
      TopicExchange ecommerceExchange) {

    return BindingBuilder.bind(paymentCompletedQueue)
        .to(ecommerceExchange)
        .with("payment.completed");
  }

}
