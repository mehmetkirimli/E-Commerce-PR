package com.reis.ecommerce.service.payment.factory;

import com.reis.ecommerce.model.enumaration.PaymentMethod;
import com.reis.ecommerce.service.payment.strategy.PaymentStrategy;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class PaymentStrategyFactory
{
  private final Map<PaymentMethod, PaymentStrategy> strategyMap;

  public PaymentStrategyFactory(List<PaymentStrategy> strategies)
  {
    this.strategyMap = strategies.stream().collect(Collectors.toMap(
            PaymentStrategy::getPaymentMethod,
            Function.identity()
        ));
  }

  public PaymentStrategy getStrategy(PaymentMethod method)
  {
    return strategyMap.get(method);
  }

}
