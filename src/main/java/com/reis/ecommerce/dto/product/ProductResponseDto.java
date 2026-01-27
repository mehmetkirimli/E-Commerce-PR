package com.reis.ecommerce.dto.product;

import lombok.*;

import java.math.BigDecimal;

/**
 * API'nin dışarıya döndüğü DTO.
 * Entity'nin tüm alanlarını dışarı açmamak için kullanılır.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDto {

  private Long id;
  private String name;
  private BigDecimal price;
  private String description;
  private Integer stock;
  private Long categoryId;
}