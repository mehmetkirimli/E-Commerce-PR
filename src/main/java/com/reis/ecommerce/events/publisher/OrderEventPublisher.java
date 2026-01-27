package com.reis.ecommerce.events.publisher;

import com.reis.ecommerce.events.model.OrderCreatedEvent;

public interface OrderEventPublisher
{
  void publish(OrderCreatedEvent event);

}
