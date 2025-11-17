package com.reis.ecommerce.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * Product e-ticaret domaininin ana modelidir.
 * BaseEntity'den türev aldığı için:
 *  - id
 *  - createdDate
 *  - createdBy
 *  - modifiedDate
 *  - modifiedBy
 *  - isDeleted
 * gibi alanlar otomatik olarak gelir.
 */

@Entity
@Table(name = "products")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity
{

 @Column(nullable = false)
 private String name;

  /**
   * Ürün fiyatı, BigDecimal kullanıyoruz çünkü fiyat hesaplarında double hata verir.
   */

 @Column(nullable = false)
 private BigDecimal price;


  /**
   * Stok miktarı.
   * NOT: Stok düşürme sırasında concurrency problemi olmaması için
   * optimistic lock (version) mekanizmasını kullanacağız.
   */
 @Column(nullable = false)
 private Integer stock;


  /**
   * Optimistic Lock alanı.
   * Aynı anda iki kişi stok güncellerse versiyon çakışması ile yarış engellenir.
   */
 @Version
 private Long version;


 @Column(nullable = false, columnDefinition = "TEXT")
 private String description;

 /**
  * Hangi kategoriye ait?
  */
 @Column(nullable = false)
 private Long categoryId;      // ✔ EKLENEN ALAN

}
