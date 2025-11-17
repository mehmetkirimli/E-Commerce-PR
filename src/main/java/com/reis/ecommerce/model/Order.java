package com.reis.ecommerce.model;

import com.reis.ecommerce.model.enumaration.OrderStatus;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity
{
  @Column(nullable = false)
  private Long userId;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private OrderStatus status;

  @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
  @Builder.Default
  private List<OrderItem> items = new ArrayList<>();


}
