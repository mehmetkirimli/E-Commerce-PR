package com.reis.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="cart_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem extends BaseEntity
{
  /**
   * Hangi ürünü tuttuğunu gösterir.
   * Bir CartItem sadece 1 ürünü temsil eder.
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  /**
   * Cart ile ManyToOne ilişkisi:
   * Bir sepetin içinde birçok CartItem vardır.
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "cart_id", nullable = false)
  private Cart cart;

  /**
   * Üründen sepete kaç adet eklendi.
   */
  @Column(nullable = false)
  private Integer quantity;

}
