package com.reis.ecommerce.controller;

import com.reis.ecommerce.common.response.ApiResponse;
import com.reis.ecommerce.dto.order.CreateOrderRequestDto;
import com.reis.ecommerce.dto.order.CreateOrderResponseDto;
import com.reis.ecommerce.service.order.IOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Order API", description = "Order creation and lifecycle APIs")
@RestController
@RequestMapping("/orders")
public class OrderController
{
  private final IOrderService orderService;

  public OrderController(IOrderService orderService)
  {
    this.orderService = orderService;
  }

  @Operation(summary = "Create new order",  description = "Creates order and triggers async payment flow" )
  @PostMapping
  public ApiResponse<CreateOrderResponseDto> createOrder( @RequestBody @Valid CreateOrderRequestDto request) {

    return orderService.createOrder(request);
  }

}
