package com.reis.ecommerce.events.publisher;

import com.reis.ecommerce.events.model.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderEventPublisherImpl implements OrderEventPublisher
{
  @Override
  public void publish(OrderCreatedEvent event)
  {
    log.info( "OrderCreatedEvent published | orderId={} | userId={} | status={}", event.getOrderId(), event.getUserId(), event.getStatus());
  }

}
