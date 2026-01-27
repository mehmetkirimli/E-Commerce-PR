package com.reis.ecommerce.service.product;

import com.reis.ecommerce.common.enumerations.MessageEnum;
import com.reis.ecommerce.common.mapper.ProductMapper;
import com.reis.ecommerce.common.response.ApiResponse;
import com.reis.ecommerce.dto.product.*;
import com.reis.ecommerce.model.Product;
import com.reis.ecommerce.repository.ProductRepository;
import io.github.resilience4j.retry.annotation.Retry;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements IProductService
{
  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  @Override
  @Retry(name = "productRetry") // Resilience4j
  @CacheEvict(value = "product_list", allEntries = true)
  public ApiResponse<ProductResponseDto> createProduct(ProductRequestDto request)
  {
    if (productRepository.existsByName(request.getName()))
    {
      return ApiResponse.fail(MessageEnum.ALREADY_EXISTS);
    }

    Product product = productMapper.toEntity(request);
    productRepository.save(product);

    return ApiResponse.success(productMapper.toResponse(product),MessageEnum.SAVED);
  }


  @Override
  @Retry(name = "productRetry")
  @Transactional
  @CacheEvict(value = "product_list", allEntries = true)
  public ApiResponse<ProductResponseDto> updateProduct(Long id, ProductRequestDto request) {

    Product product = productRepository.findById(id)
        .orElse(null);

    if (product == null) {
      return ApiResponse.fail(MessageEnum.NOT_FOUND);
    }

    // Mapper → updateEntity (Builder değil update)
    ProductMapper.updateEntity(product, request);

    // @Version alanı sayesinde optimistic lock devrede olacak
    productRepository.save(product);

    return ApiResponse.success(productMapper.toResponse(product),MessageEnum.UPDATED);
  }

  /**
   * Ürün silme
   * - Soft delete değil, normal delete kullanıyoruz (isteğe göre değişir)
   */
  @Override
  @CacheEvict(value = "product_list", allEntries = true)
  public ApiResponse<Boolean> deleteProduct(Long id) {

    Product product = productRepository.findById(id)
        .orElse(null);

    if (product == null) {
      return ApiResponse.fail(MessageEnum.NOT_FOUND);
    }

    productRepository.delete(product);

    return ApiResponse.success(true, MessageEnum.DELETED);
  }

  /**
   * Ürün detayını getir
   */
  @Override
  public ApiResponse<ProductResponseDto> getProduct(Long id) {

    Product product = productRepository.findById(id)
        .orElse(null);

    if (product == null) {
      return ApiResponse.fail(MessageEnum.NOT_FOUND);
    }

    return ApiResponse.success(ProductMapper.toResponse(product)
    );
  }

  /**
   * Ürün listesini getir
   * - Redis Cache burada devrede
   */
  @Override
  @Cacheable(value = "product_list")
  public ApiResponse<List<ProductListResponseDto>> getAllProducts() {

    List<ProductListResponseDto> list = productRepository.findAll()
        .stream()
        .map(ProductMapper::toListResponse)
        .collect(Collectors.toList());

    return ApiResponse.success(list);
  }

}
