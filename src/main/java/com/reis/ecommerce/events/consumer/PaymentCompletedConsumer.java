package com.reis.ecommerce.events.consumer;

import com.reis.ecommerce.config.RabbitMqConfig.RabbitMqConfig;
import com.reis.ecommerce.events.model.PaymentCompletedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaymentCompletedConsumer
{
  @RabbitListener(queues = RabbitMqConfig.PAYMENT_COMPLETED_QUEUE)
  public void consume(PaymentCompletedEvent event)
  {

    log.info("PaymentCompletedEvent received. orderId={} status={}",event.getOrderId(),event.getStatus());

    // Burası Redis cache için mükemmel yer (bir sonraki adım)
  }
}
