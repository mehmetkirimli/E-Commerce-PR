package com.reis.ecommerce.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
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
  private Long userId;

  private BigDecimal totalPrice;

  @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<CartItem> items = new ArrayList<>();

  public void addItem(CartItem item) {
    items.add(item);
    item.setCart(this);
  }

  public void removeItem(CartItem item) {
    items.remove(item);
    item.setCart(null);
  }
}
