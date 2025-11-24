package com.reis.ecommerce.controller;

import com.reis.ecommerce.common.response.ApiResponse;
import com.reis.ecommerce.dto.cart.AddToCartRequest;
import com.reis.ecommerce.dto.cart.CartResponse;
import com.reis.ecommerce.service.cart.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

  private final ICartService cartService;

  @PostMapping("/add")
  public ApiResponse<CartResponse> addToCart(@RequestBody AddToCartRequest request) {
    return cartService.addToCart(request);
  }

  @DeleteMapping("/remove/{userId}/{productId}")
  public ApiResponse<CartResponse> removeFromCart(
      @PathVariable Long userId,
      @PathVariable Long productId
  ) {
    return cartService.removeFromCart(userId, productId);
  }

  @GetMapping("/{userId}")
  public ApiResponse<CartResponse> getCart(@PathVariable Long userId) {
    return cartService.getCart(userId);
  }
}
