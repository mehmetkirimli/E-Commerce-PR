package com.reis.ecommerce.service.cart;

import com.reis.ecommerce.common.response.ApiResponse;
import com.reis.ecommerce.dto.cart.AddToCartRequestDto;
import com.reis.ecommerce.dto.cart.CartResponseDto;

public interface ICartService {
  ApiResponse<CartResponseDto> addToCart(AddToCartRequestDto request);
  ApiResponse<CartResponseDto> removeFromCart(Long userId, Long productId);
  ApiResponse<CartResponseDto> getCart(Long userId);
}