package com.reis.ecommerce.service.product;

import com.reis.ecommerce.common.response.ApiResponse;
import com.reis.ecommerce.dto.product.ProductListResponse;
import com.reis.ecommerce.dto.product.ProductRequest;
import com.reis.ecommerce.dto.product.ProductResponse;
import java.util.List;

public interface IProductService
{
  ApiResponse<ProductResponse> createProduct(ProductRequest request);

  /**
   * Ürünü güncelleme.
   *  - Optimistic Lock
   *  - Retry
   *  - Mapper Pattern
   */
  ApiResponse<ProductResponse> updateProduct(Long id, ProductRequest request);

  /**
   * Ürünü silme (soft delete olabilir).
   */
  ApiResponse<Boolean> deleteProduct(Long id);

  /**
   * Ürün detayını getir.
   */
  ApiResponse<ProductResponse> getProduct(Long id);

  /**
   * Ürün listesini getir.
   *  - Redis Cache burada devreye girer
   */
  ApiResponse<List<ProductListResponse>> getAllProducts();

}
