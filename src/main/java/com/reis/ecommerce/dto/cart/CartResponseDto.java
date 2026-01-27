package com.reis.ecommerce.dto.cart;

import java.math.BigDecimal;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CartResponseDto
{
  private Long cartId;
  private Long userId;
  private BigDecimal totalPrice;
  private List<CartItemResponseDto> items;

}
