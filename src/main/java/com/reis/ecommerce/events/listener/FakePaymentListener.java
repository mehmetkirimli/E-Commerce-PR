package com.reis.ecommerce.events.listener;

import com.reis.ecommerce.events.model.OrderCreatedEvent;
import com.reis.ecommerce.model.enumaration.PaymentStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
@Slf4j
public class FakePaymentListener
{
  private final ApplicationEventPublisher applicationEventPublisher;

  @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
  public void handle(OrderCreatedEvent event)
  {
   try
   {
     Thread.sleep(1000); // dümenden latency simülasyonu
   }
   catch (Exception e)
   {
     log.error("Error in FakePaymentListener for orderId={}", event.getOrderId(), e);
   }

   String status = Math.random() > 0.2 ? PaymentStatus.SUCCESS.name() : PaymentStatus.FAILED.name();
  }

}
