package com.reis.ecommerce.common.mapper;

import com.reis.ecommerce.model.Order;
import com.reis.ecommerce.model.PaymentDetail;
import com.reis.ecommerce.model.enumaration.PaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper
{
  public PaymentDetail toDetail(
      Order order,
      PaymentMethod method,
      String maskedCard,
      Integer installment,
      Long couponId
  ) {
    return PaymentDetail.builder()
        .order(order)
        .method(method)
        .maskedCard(maskedCard)
        .installment(installment)
        .couponId(couponId)
        .note("Fake payment")
        .build();
  }

}
