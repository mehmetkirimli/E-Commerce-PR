package com.reis.ecommerce.events.model;

import java.time.LocalDateTime;

public class PaymentCompletedEvent
{
  private final Long orderId;
  private final String status;
  private final LocalDateTime processedAt;

  public PaymentCompletedEvent(Long orderId,String status,LocalDateTime processedAt) {
    this.orderId = orderId;
    this.status = status;
    this.processedAt = processedAt;
  }

  public Long getOrderId() { return orderId; }
  public String getStatus() { return status; }
  public LocalDateTime getProcessedAt() { return processedAt; }

}
