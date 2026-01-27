package com.reis.ecommerce.dto.product;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDto
{
  @NotBlank(message = "Product name cannot be empty")
  private String name;

  @NotNull(message = "Price is required")
  @Positive(message = "Price must be greater than 0")
  private BigDecimal price;

  @NotBlank(message = "Description cannot be empty")
  private String description;

  @NotNull(message = "CategoryId is required")
  private Long categoryId;

  @NotNull(message = "Stock value is required")
  @Min(value = 0, message = "Stock cannot be negative")
  private Integer stock;

}
