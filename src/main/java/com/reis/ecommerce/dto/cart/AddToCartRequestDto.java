package com.reis.ecommerce.dto.cart;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddToCartRequestDto
{
  private Long userId;
  private Long productId;
  private Integer quantity;

}
