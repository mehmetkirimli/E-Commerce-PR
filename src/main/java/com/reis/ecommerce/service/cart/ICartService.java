package com.reis.ecommerce.service.cart;

import com.reis.ecommerce.common.response.ApiResponse;
import com.reis.ecommerce.dto.cart.AddToCartRequest;
import com.reis.ecommerce.dto.cart.CartResponse;

public interface ICartService {
  ApiResponse<CartResponse> addToCart(AddToCartRequest request);
  ApiResponse<CartResponse> removeFromCart(Long userId, Long productId);
  ApiResponse<CartResponse> getCart(Long userId);
}