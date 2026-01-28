package com.reis.ecommerce.events.publisher;

import com.reis.ecommerce.config.RabbitMqConfig.RabbitMqConfig;
import com.reis.ecommerce.events.model.PaymentCompletedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class PaymentCompletedPublisher
{
  private final RabbitTemplate rabbitTemplate;

  public void publish(PaymentCompletedEvent event)
  {
    rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE,"payment.completed",event);

    log.info("PaymentCompletedEvent sent. orderId={} status={}", event.getOrderId(), event.getStatus());
  }
}
