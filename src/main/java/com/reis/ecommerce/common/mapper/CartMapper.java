package com.reis.ecommerce.common.mapper;

import com.reis.ecommerce.dto.cart.CartItemResponseDto;
import com.reis.ecommerce.dto.cart.CartResponseDto;
import com.reis.ecommerce.model.Cart;
import com.reis.ecommerce.model.CartItem;
import java.util.stream.Collectors;

public class CartMapper {

  public static CartResponseDto toResponse(Cart cart) {
    return CartResponseDto.builder()
        .cartId(cart.getId())
        .userId(cart.getUserId())
        .totalPrice(cart.getTotalPrice())
        .items(cart.getItems().stream()
            .map(CartMapper::toItemResponse)
            .collect(Collectors.toList()))
        .build();
  }

  public static CartItemResponseDto toItemResponse(CartItem item) {
    return CartItemResponseDto.builder()
        .productId(item.getProductId())
        .quantity(item.getQuantity())
        .unitPrice(item.getUnitPrice())
        .build();
  }
}
