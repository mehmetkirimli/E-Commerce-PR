package com.reis.ecommerce.events.listener;

import com.reis.ecommerce.events.model.OrderCreatedEvent;
import com.reis.ecommerce.events.publisher.OrderEventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderCreatedEventListener
{
  private final OrderEventPublisher orderEventPublisher;

  @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
  public void handle(OrderCreatedEvent event)
  {
    log.info("AFTER_COMMIT reached for OrderCreatedEvent. orderId={}", event.getOrderId() );

    orderEventPublisher.publish(event); // dış sistemlere event publish committen sonra yapılır
  }
}
