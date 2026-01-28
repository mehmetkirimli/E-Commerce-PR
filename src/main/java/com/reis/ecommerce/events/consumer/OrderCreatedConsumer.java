package com.reis.ecommerce.events.consumer;

import com.reis.ecommerce.config.RabbitMqConfig.RabbitMqConfig;
import com.reis.ecommerce.events.model.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderCreatedConsumer
{

  @RabbitListener(queues = RabbitMqConfig.ORDER_CREATED_QUEUE)
  public void consume(OrderCreatedEvent event)
  {
    log.info("OrderCreatedEvent received from RabbitMQ. orderId={}", event.getOrderId() );
    //TODO Payment trigger’ı buraya da taşıyabiliriz (ileride)
  }
}
