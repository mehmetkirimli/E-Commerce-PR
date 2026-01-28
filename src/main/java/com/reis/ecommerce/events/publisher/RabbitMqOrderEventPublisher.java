package com.reis.ecommerce.events.publisher;

import com.reis.ecommerce.config.RabbitMqConfig.RabbitMqConfig;
import com.reis.ecommerce.events.model.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitMqOrderEventPublisher implements OrderEventPublisher
{
  private final RabbitTemplate rabbitTemplate;
  @Override
  public void publish(OrderCreatedEvent event)
  {
    rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE,"order.created",event);

    log.info("OrderCreatedEvent sent to RabbitMQ. orderId={}",event.getOrderId());
  }
}
