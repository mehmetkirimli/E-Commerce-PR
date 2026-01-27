package com.reis.ecommerce.service.order;

import com.reis.ecommerce.common.response.ApiResponse;
import com.reis.ecommerce.dto.order.CreateOrderRequestDto;
import com.reis.ecommerce.dto.order.CreateOrderResponseDto;

public interface IOrderService
{
  ApiResponse<CreateOrderResponseDto> createOrder(CreateOrderRequestDto request);

}
