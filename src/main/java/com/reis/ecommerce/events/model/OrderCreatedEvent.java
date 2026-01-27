package com.reis.ecommerce.events.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class OrderCreatedEvent implements Serializable {

  private final Long orderId;
  private final Long userId;
  private final String status;
  private final LocalDateTime createdAt;

  public OrderCreatedEvent(Long orderId,Long userId,String status,LocalDateTime createdAt)
  {
    this.orderId = orderId;
    this.userId = userId;
    this.status = status;
    this.createdAt = createdAt;
  }

  public Long getOrderId() {
    return orderId;
  }

  public Long getUserId() {
    return userId;
  }

  public String getStatus() {
    return status;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
}
