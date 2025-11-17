package com.reis.ecommerce.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="carts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends BaseEntity
{
  @Column(nullable = false)
  private Long userId;

  /**
   * Cart → CartItem ilişkisi.
   * Sepette birden fazla ürün olabilir.
   * Cascade.ALL → Cart silinirse item'lar da silinir.
   * OrphanRemoval → item listeden çıkarılırsa DB’den silinir.
   */
  @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
  @Builder.Default
  private List<CartItem> items = new ArrayList<>();
}
