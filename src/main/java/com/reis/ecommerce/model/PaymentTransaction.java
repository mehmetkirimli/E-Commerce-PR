package com.reis.ecommerce.model;


import com.reis.ecommerce.model.enumaration.PaymentStatus;
import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment_transactions")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTransaction extends BaseEntity
{
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id",nullable = false)
  private Order order;

  @Column(nullable = false)
  private BigDecimal amount;

  /**
   * Ödeme sağlayıcısı (iyzico, stripe, paypal vs.)
   */
  @Column(nullable = false)
  private String provider;

  private String providerTransactionId;

  @Column(unique = true,nullable = false)
  private String idempotencyKey;

  /**
   * Payment retry sayısı.
   * Resilience4j ile retry yaptığımızda bu alan güncellenir.
   */
  @Column(nullable = false)
  @Builder.Default
  private Integer retryCount = 0;

  /**
   * Callback kaç kere geldi?
   * Duplicate callback handling için
   */
  @Builder.Default
  private Integer callbackCount = 0;

  /**
   * Ödemenin durumu: PENDING, SUCCESS, FAILED…
   */
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private PaymentStatus status;

  /**
   * Ödeme sağlayıcısından gelen raw JSON response
   * Hata çözümlemede çok önemli.
   */
  @Lob
  private String providerResponse;


}
