package com.reis.ecommerce.dto.order;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderRequestDto
{
  @NotNull
  private Long userId;

  @NotEmpty
  private List<OrderItemRequestDto> items;

}
