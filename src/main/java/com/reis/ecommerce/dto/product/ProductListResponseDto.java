package com.reis.ecommerce.dto.product;

import lombok.*;

import java.math.BigDecimal;

/**
 * Liste operasyonlarında performans için daha hafif DTO.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductListResponseDto {

  private Long id;
  private String name;
  private BigDecimal price;
}