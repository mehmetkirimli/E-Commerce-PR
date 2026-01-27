package com.reis.ecommerce.dto.order;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemRequestDto
{
  @NotNull
  private Long productId;

  @NotNull
  private Integer quantity;
}
