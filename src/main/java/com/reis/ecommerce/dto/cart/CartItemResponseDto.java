package com.reis.ecommerce.dto.cart;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CartItemResponseDto {
  private Long productId;
  private Integer quantity;
  private BigDecimal unitPrice;
}