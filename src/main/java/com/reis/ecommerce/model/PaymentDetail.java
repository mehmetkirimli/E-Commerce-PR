package com.reis.ecommerce.model;

import com.reis.ecommerce.model.enumaration.PaymentMethod;
import jakarta.persistence.*;
import lombok.*;

/**
 * PaymentDetail ödeme yöntemine bağlı açıklayıcı bilgileri içerir.
 * Örn: Kredi kartı maskeli numara, taksit sayısı, banka adı, kupon id vs.
 */
@Entity
@Table(name = "payment_details")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetail extends BaseEntity {

  /**
   * Hangi order'ın ödeme methodu?
   */
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id", nullable = false)
  private Order order;

  /**
   * Ödeme yöntemi (kredi kartı, havale vs.)
   */
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private PaymentMethod method;

  /**
   * Maskelenmiş kart bilgisi
   * Örn: 5523 **** **** 1233
   */
  private String maskedCard;

  /**
   * Taksit sayısı
   */
  private Integer installment;

  /**
   * Kullanılan kupon ID (varsa)
   */
  private Long couponId;

  /**
   * Opsiyonel açıklama (banka, POS, gateway notları…)
   */
  private String note;
}