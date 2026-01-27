package com.reis.ecommerce.common.mapper;

import com.reis.ecommerce.dto.order.CreateOrderRequestDto;
import com.reis.ecommerce.dto.order.CreateOrderResponseDto;
import com.reis.ecommerce.events.model.OrderCreatedEvent;
import com.reis.ecommerce.model.Order;
import com.reis.ecommerce.model.enumaration.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper
{

  public Order toEntity(CreateOrderRequestDto request)
  {
    Order order = new Order();
    order.setUserId(request.getUserId());
    order.setStatus(OrderStatus.CREATED);
    return order;
  }

  public CreateOrderResponseDto toResponse(Order order)
  {
    return new CreateOrderResponseDto(
        order.getId(),
        order.getStatus().name(),
        order.getCreatedDate()
    );
  }

  public OrderCreatedEvent toOrderCreatedEvent(Order order)
  {
    return new OrderCreatedEvent(
        order.getId(),
        order.getUserId(),
        order.getStatus().name(),
        order.getCreatedDate()
    );
  }

}
