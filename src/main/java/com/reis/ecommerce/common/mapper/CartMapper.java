package com.reis.ecommerce.common.mapper;

import com.reis.ecommerce.dto.cart.CartItemResponse;
import com.reis.ecommerce.dto.cart.CartResponse;
import com.reis.ecommerce.model.Cart;
import com.reis.ecommerce.model.CartItem;
import java.util.stream.Collectors;

public class CartMapper {

  public static CartResponse toResponse(Cart cart) {
    return CartResponse.builder()
        .cartId(cart.getId())
        .userId(cart.getUserId())
        .totalPrice(cart.getTotalPrice())
        .items(cart.getItems().stream()
            .map(CartMapper::toItemResponse)
            .collect(Collectors.toList()))
        .build();
  }

  public static CartItemResponse toItemResponse(CartItem item) {
    return CartItemResponse.builder()
        .productId(item.getProductId())
        .quantity(item.getQuantity())
        .unitPrice(item.getUnitPrice())
        .build();
  }
}
