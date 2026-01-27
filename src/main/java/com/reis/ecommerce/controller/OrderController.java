package com.reis.ecommerce.controller;

import com.reis.ecommerce.common.response.ApiResponse;
import com.reis.ecommerce.dto.order.CreateOrderRequestDto;
import com.reis.ecommerce.dto.order.CreateOrderResponseDto;
import com.reis.ecommerce.service.order.IOrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController
{
  private final IOrderService orderService;

  public OrderController(IOrderService orderService)
  {
    this.orderService = orderService;
  }

  @PostMapping
  public ApiResponse<CreateOrderResponseDto> createOrder( @RequestBody @Valid CreateOrderRequestDto request) {

    return orderService.createOrder(request);
  }

}
