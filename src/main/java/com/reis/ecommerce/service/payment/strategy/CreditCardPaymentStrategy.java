package com.reis.ecommerce.service.payment.strategy;


import com.reis.ecommerce.model.PaymentDetail;
import com.reis.ecommerce.model.enumaration.PaymentMethod;
import com.reis.ecommerce.model.enumaration.PaymentStatus;
import org.springframework.stereotype.Component;

@Component
public class CreditCardPaymentStrategy implements PaymentStrategy
{

  @Override
  public PaymentMethod getPaymentMethod() {
    return PaymentMethod.CREDIT_CARD;
  }

  @Override
  public PaymentStatus process(PaymentDetail paymentDetail)
  {
    try
    {
      Thread.sleep(1000); // dümenden banka latency
      return Math.random() > 0.2 ? PaymentStatus.SUCCESS : PaymentStatus.FAILED;
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }
  }
}
