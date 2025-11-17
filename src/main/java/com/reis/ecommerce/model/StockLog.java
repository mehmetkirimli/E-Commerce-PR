package com.reis.ecommerce.model;

import com.reis.ecommerce.model.enumaration.StockAction;
import jakarta.persistence.*;
import lombok.*;

/**
 * StockLog tüm stok değişimlerinin kaydını tutar.
 * Bu yapı sayesinde:
 *  - concurrency sorunlarını analiz ederiz
 *  - saga rollback durumlarını takip ederiz
 *  - yanlış stok düşümü varsa tespit ederiz
 */
@Entity
@Table(name = "stock_log")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockLog extends BaseEntity {

  /**
   * Hangi ürün için stok değişti?
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  /**
   * Stok değişim miktarı (+ veya - olabilir)
   */
  @Column(nullable = false)
  private Integer quantityChange;

  /**
   * İşlem sonrası kalan stok.
   */
  @Column(nullable = false)
  private Integer finalStock;

  /**
   * Stok değişiminin nedeni.
   */
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private StockAction action;

  /**
   * Hangi sipariş/stok operasyonu tetikledi?
   * Order ile ilişkili olmak zorunda değil.
   */
  private Long referenceId;
}