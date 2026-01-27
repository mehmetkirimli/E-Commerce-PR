package com.reis.ecommerce.service.payment.strategy;

import com.reis.ecommerce.model.PaymentDetail;
import com.reis.ecommerce.model.enumaration.PaymentMethod;
import com.reis.ecommerce.model.enumaration.PaymentStatus;

public interface PaymentStrategy
{
  PaymentMethod getPaymentMethod();
  PaymentStatus process(PaymentDetail paymentDetail);
}
