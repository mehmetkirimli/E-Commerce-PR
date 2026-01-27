package com.reis.ecommerce.controller;

import com.reis.ecommerce.common.response.ApiResponse;
import com.reis.ecommerce.dto.cart.AddToCartRequestDto;
import com.reis.ecommerce.dto.cart.CartResponseDto;
import com.reis.ecommerce.service.cart.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

  private final ICartService cartService;

  @PostMapping("/add")
  public ApiResponse<CartResponseDto> addToCart(@RequestBody AddToCartRequestDto request) {
    return cartService.addToCart(request);
  }

  @DeleteMapping("/remove/{userId}/{productId}")
  public ApiResponse<CartResponseDto> removeFromCart(
      @PathVariable Long userId,
      @PathVariable Long productId
  ) {
    return cartService.removeFromCart(userId, productId);
  }

  @GetMapping("/{userId}")
  public ApiResponse<CartResponseDto> getCart(@PathVariable Long userId) {
    return cartService.getCart(userId);
  }
}
