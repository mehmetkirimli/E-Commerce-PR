package com.reis.ecommerce.common.mapper;

import com.reis.ecommerce.dto.product.ProductListResponse;
import com.reis.ecommerce.dto.product.ProductRequest;
import com.reis.ecommerce.dto.product.ProductResponse;
import com.reis.ecommerce.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper
{
  /**
   * ProductRequest → Product (insert için)
   */
  public static Product toEntity(ProductRequest request) {
    return Product.builder()
        .name(request.getName())
        .price(request.getPrice())
        .description(request.getDescription())
        .categoryId(request.getCategoryId())
        .stock(request.getStock())
        .build();
  }

  /**
   * ProductRequest + existing Product → Product (update için)
   */
  public static Product updateEntity(Product product, ProductRequest request) {
    product.setName(request.getName());
    product.setPrice(request.getPrice());
    product.setDescription(request.getDescription());
    product.setCategoryId(request.getCategoryId());
    product.setStock(request.getStock());
    return product;
  }

  /**
   * Product → ProductResponse
   */
  public static ProductResponse toResponse(Product product) {
    return ProductResponse.builder()
        .id(product.getId())
        .name(product.getName())
        .price(product.getPrice())
        .description(product.getDescription())
        .stock(product.getStock())
        .categoryId(product.getCategoryId())
        .build();
  }

  /**
   * Product → ProductListResponse (liste dönüşü için performanslı DTO)
   */
  public static ProductListResponse toListResponse(Product product) {
    return ProductListResponse.builder()
        .id(product.getId())
        .name(product.getName())
        .price(product.getPrice())
        .build();
  }



}
