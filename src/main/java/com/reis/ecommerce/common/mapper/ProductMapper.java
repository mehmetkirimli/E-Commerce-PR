package com.reis.ecommerce.common.mapper;

import com.reis.ecommerce.dto.product.ProductListResponseDto;
import com.reis.ecommerce.dto.product.ProductRequestDto;
import com.reis.ecommerce.dto.product.ProductResponseDto;
import com.reis.ecommerce.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper
{
  /**
   * ProductRequestDto → Product (insert için)
   */
  public static Product toEntity(ProductRequestDto request) {
    return Product.builder()
        .name(request.getName())
        .price(request.getPrice())
        .description(request.getDescription())
        .categoryId(request.getCategoryId())
        .stock(request.getStock())
        .build();
  }

  /**
   * ProductRequestDto + existing Product → Product (update için)
   */
  public static Product updateEntity(Product product, ProductRequestDto request) {
    product.setName(request.getName());
    product.setPrice(request.getPrice());
    product.setDescription(request.getDescription());
    product.setCategoryId(request.getCategoryId());
    product.setStock(request.getStock());
    return product;
  }

  /**
   * Product → ProductResponseDto
   */
  public static ProductResponseDto toResponse(Product product) {
    return ProductResponseDto.builder()
        .id(product.getId())
        .name(product.getName())
        .price(product.getPrice())
        .description(product.getDescription())
        .stock(product.getStock())
        .categoryId(product.getCategoryId())
        .build();
  }

  /**
   * Product → ProductListResponseDto (liste dönüşü için performanslı DTO)
   */
  public static ProductListResponseDto toListResponse(Product product) {
    return ProductListResponseDto.builder()
        .id(product.getId())
        .name(product.getName())
        .price(product.getPrice())
        .build();
  }



}
