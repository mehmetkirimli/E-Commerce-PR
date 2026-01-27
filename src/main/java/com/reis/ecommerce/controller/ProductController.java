package com.reis.ecommerce.controller;

import com.reis.ecommerce.common.response.ApiResponse;
import com.reis.ecommerce.dto.product.*;
import com.reis.ecommerce.service.product.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

  private final IProductService productService;

  /**
   * Create Product
   */
  @PostMapping
  public ApiResponse<ProductResponseDto> createProduct(@RequestBody @Valid ProductRequestDto request) {
    return productService.createProduct(request);
  }

  /**
   * Update Product
   */
  @PutMapping("/{id}")
  public ApiResponse<ProductResponseDto> updateProduct(
      @PathVariable Long id,
      @RequestBody @Valid ProductRequestDto request
  ) {
    return productService.updateProduct(id, request);
  }

  /**
   * Delete Product
   */
  @DeleteMapping("/{id}")
  public ApiResponse<Boolean> deleteProduct(@PathVariable Long id) {
    return productService.deleteProduct(id);
  }

  /**
   * Get Product by Id
   */
  @GetMapping("/{id}")
  public ApiResponse<ProductResponseDto> getProduct(@PathVariable Long id) {
    return productService.getProduct(id);
  }

  /**
   * List Products
   */
  @GetMapping
  public ApiResponse<List<ProductListResponseDto>> getAllProducts() {
    return productService.getAllProducts();
  }
}
