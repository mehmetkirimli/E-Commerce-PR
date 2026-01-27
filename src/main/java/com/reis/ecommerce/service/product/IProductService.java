package com.reis.ecommerce.service.product;

import com.reis.ecommerce.common.response.ApiResponse;
import com.reis.ecommerce.dto.product.ProductListResponseDto;
import com.reis.ecommerce.dto.product.ProductRequestDto;
import com.reis.ecommerce.dto.product.ProductResponseDto;
import java.util.List;

public interface IProductService
{
  ApiResponse<ProductResponseDto> createProduct(ProductRequestDto request);

  /**
   * Ürünü güncelleme.
   *  - Optimistic Lock
   *  - Retry
   *  - Mapper Pattern
   */
  ApiResponse<ProductResponseDto> updateProduct(Long id, ProductRequestDto request);

  /**
   * Ürünü silme (soft delete olabilir).
   */
  ApiResponse<Boolean> deleteProduct(Long id);

  /**
   * Ürün detayını getir.
   */
  ApiResponse<ProductResponseDto> getProduct(Long id);

  /**
   * Ürün listesini getir.
   *  - Redis Cache burada devreye girer
   */
  ApiResponse<List<ProductListResponseDto>> getAllProducts();

}
