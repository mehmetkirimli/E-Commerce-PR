package com.reis.ecommerce.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_items")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem extends BaseEntity
{
  /**
   * Bu order item hangi order'a ait.
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id", nullable = false)
  private Order order;

  /**
   * Hangi ürüne ait olduğu — order sonrası bu bilgi tarihsel kayıttır.
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  /**
   * Sipariş anındaki fiyat — product.price'tan kopyalanır.
   */
  @Column(nullable = false)
  private BigDecimal price;

  /**
   * Kaç adet alındı.
   */
  @Column(nullable = false)
  private Integer quantity;

}
