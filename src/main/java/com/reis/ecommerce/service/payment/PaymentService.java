package com.reis.ecommerce.service.payment;

import com.reis.ecommerce.common.mapper.PaymentMapper;
import com.reis.ecommerce.model.PaymentDetail;
import com.reis.ecommerce.model.PaymentTransaction;
import com.reis.ecommerce.model.enumaration.PaymentMethod;
import com.reis.ecommerce.model.enumaration.PaymentStatus;
import com.reis.ecommerce.repository.OrderRepository;
import com.reis.ecommerce.repository.PaymentDetailRepository;
import com.reis.ecommerce.repository.PaymentTransactionRepository;
import com.reis.ecommerce.service.payment.factory.PaymentStrategyFactory;
import com.reis.ecommerce.service.payment.strategy.PaymentStrategy;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reis.ecommerce.model.Order;


@Service
@RequiredArgsConstructor
public class PaymentService
{
  private final OrderRepository orderRepository; //TODO Service üzerinden çağır .

  private final PaymentDetailRepository paymentDetailRepository;
  private final PaymentTransactionRepository paymentTransactionRepository;
  private final PaymentStrategyFactory strategyFactory;
  private final PaymentMapper paymentMapper;


  @Transactional
  public PaymentStatus processPayment(Long orderId , PaymentMethod paymentMethod)
  {
    Order order = orderRepository.findById(orderId).orElseThrow(()-> new IllegalArgumentException("Order not found : " + orderId));

    PaymentDetail detail = paymentMapper.toDetail(order,paymentMethod,"5523 **** **** 1233",3,null);
    paymentDetailRepository.save(detail);

    PaymentStrategy strategy = strategyFactory.getStrategy(paymentMethod);
    PaymentStatus resultStatus = strategy.process(detail);

    PaymentTransaction transaction =
        PaymentTransaction.builder()
            .order(order)
            .amount(BigDecimal.valueOf(2750.45))
            .provider("KPay") // Dümenden bu normalde dinamik gelecek
            .idempotencyKey(UUID.randomUUID().toString())
            .status(PaymentStatus.PENDING)
            .providerResponse("FAKE_PROVIDER_RESPONSE")
            .build();

    paymentTransactionRepository.save(transaction);

    return resultStatus;

  }
}
