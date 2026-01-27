package com.reis.ecommerce.service.cart;

import com.reis.ecommerce.common.response.ApiResponse;
import com.reis.ecommerce.common.mapper.CartMapper;
import com.reis.ecommerce.common.enumerations.MessageEnum;
import com.reis.ecommerce.dto.cart.AddToCartRequestDto;
import com.reis.ecommerce.dto.cart.CartResponseDto;
import com.reis.ecommerce.model.Cart;
import com.reis.ecommerce.model.CartItem;
import com.reis.ecommerce.repository.CartRepository;
import com.reis.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements ICartService {

  private final CartRepository cartRepository;
  private final ProductRepository productRepository;

  /**
   * Kullanıcıya ait cart yoksa oluşturur,
   * varsa içine item ekler.
   */
  @Override
  public ApiResponse<CartResponseDto> addToCart(AddToCartRequestDto request) {

    // Kullanıcının cart'ı var mı?
    Cart cart = cartRepository.findByUserId(request.getUserId())
        .orElse(Cart.builder()
            .userId(request.getUserId())
            .totalPrice(BigDecimal.ZERO)
            .build()
        );

    // Ürün fiyatını bul
    var product = productRepository.findById(request.getProductId())
        .orElse(null);

    if (product == null)
      return ApiResponse.fail(MessageEnum.NOT_FOUND);

    // CartItem oluştur
    CartItem item = CartItem.builder()
        .productId(request.getProductId())
        .quantity(request.getQuantity())
        .unitPrice(product.getPrice())
        .build();

    // Cart'a ekle
    cart.addItem(item);

    // Total price güncelle
    BigDecimal addPrice = item.getUnitPrice()
        .multiply(BigDecimal.valueOf(item.getQuantity()));

    cart.setTotalPrice(cart.getTotalPrice().add(addPrice));

    cartRepository.save(cart);

    return ApiResponse.success(CartMapper.toResponse(cart), MessageEnum.SAVED);
  }

  /**
   * Sepetten ürün silme
   */
  @Override
  public ApiResponse<CartResponseDto> removeFromCart(Long userId, Long productId) {

    Cart cart = cartRepository.findByUserId(userId)
        .orElse(null);

    if (cart == null)
      return ApiResponse.fail(MessageEnum.NOT_FOUND);

    CartItem itemToRemove = cart.getItems()
        .stream()
        .filter(i -> i.getProductId().equals(productId))
        .findFirst()
        .orElse(null);

    if (itemToRemove == null)
      return ApiResponse.fail(MessageEnum.NOT_FOUND);

    // total price güncelle
    BigDecimal removePrice = itemToRemove.getUnitPrice()
        .multiply(BigDecimal.valueOf(itemToRemove.getQuantity()));
    cart.setTotalPrice(cart.getTotalPrice().subtract(removePrice));

    cart.removeItem(itemToRemove);
    cartRepository.save(cart);

    return ApiResponse.success(CartMapper.toResponse(cart), MessageEnum.DELETED);
  }

  /**
   * Kullanıcının cart'ını getirir
   */
  @Override
  public ApiResponse<CartResponseDto> getCart(Long userId) {

    Cart cart = cartRepository.findByUserId(userId)
        .orElse(null);

    if (cart == null)
      return ApiResponse.fail(MessageEnum.NOT_FOUND);

    return ApiResponse.success(CartMapper.toResponse(cart));
  }
}
