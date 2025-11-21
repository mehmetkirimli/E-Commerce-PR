package com.reis.ecommerce.dto.cart;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CartItemResponse {
  private Long productId;
  private Integer quantity;
  private BigDecimal unitPrice;
}