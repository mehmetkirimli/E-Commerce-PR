package com.reis.ecommerce.service.payment.strategy;

import com.reis.ecommerce.model.PaymentDetail;
import com.reis.ecommerce.model.enumaration.PaymentMethod;
import com.reis.ecommerce.model.enumaration.PaymentStatus;
import org.springframework.stereotype.Component;

@Component
public class WalletPaymentStrategy implements PaymentStrategy
{
  @Override
  public PaymentMethod getPaymentMethod() {
    return PaymentMethod.WALLET;
  }

  @Override
  public PaymentStatus process(PaymentDetail paymentDetail) {

    sleep(200); // daha hızlı :)

    return Math.random() > 0.1
        ? PaymentStatus.SUCCESS
        : PaymentStatus.FAILED;
  }

  private void sleep(long ms) {
    try { Thread.sleep(ms); } catch (Exception ignored) {}
  }
}
