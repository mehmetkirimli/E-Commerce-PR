package com.reis.ecommerce.dto.order;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class CreateOrderResponseDto
{
  private Long orderId;
  private String status;
  private LocalDateTime createdAt;

  public CreateOrderResponseDto(Long orderId,
      String status,
      LocalDateTime createdAt) {
    this.orderId = orderId;
    this.status = status;
    this.createdAt = createdAt;
  }

}
