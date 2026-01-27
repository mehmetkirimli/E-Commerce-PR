package com.reis.ecommerce.service.order;

import com.reis.ecommerce.common.mapper.OrderMapper;
import com.reis.ecommerce.common.response.ApiResponse;
import com.reis.ecommerce.dto.order.CreateOrderRequestDto;
import com.reis.ecommerce.dto.order.CreateOrderResponseDto;
import com.reis.ecommerce.events.model.OrderCreatedEvent;
import com.reis.ecommerce.events.publisher.OrderEventPublisher;
import com.reis.ecommerce.model.Order;
import com.reis.ecommerce.model.enumaration.OrderStatus;
import com.reis.ecommerce.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService
{
  private final OrderRepository orderRepository;
  private final OrderMapper orderMapper;
  private final OrderEventPublisher orderEventPublisher;

  @Override
  public ApiResponse<CreateOrderResponseDto> createOrder(CreateOrderRequestDto request)
  {
    Order order = orderMapper.toEntity(request); // request -> entity

    Order savedOrder = orderRepository.save(order); // db save

    OrderCreatedEvent event = orderMapper.toOrderCreatedEvent(savedOrder); // entity -> event

    orderEventPublisher.publish(event); // event publish

    CreateOrderResponseDto responseDto = orderMapper.toResponse(savedOrder); // entity -> responseDto

    return ApiResponse.success(responseDto);
  }


}
