package com.reis.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


/**
 * Tüm entity'lerde ortak olacak alanlar.
 * Bu sınıf abstract, yani direkt instance alınmaz.
 */

@MappedSuperclass
@Getter
@Setter

public abstract class BaseEntity {

  /**
   * Her entity için benzersiz ID.
   * UUID yerine Long kullanıyoruz ama istersen UUID'e geçebiliriz.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * Soft delete için kullanılır.
   * isDeleted = true → DB’de kayıt durur ama sistemde görünmez.
   */
  @Column(nullable = false)
  private boolean isDeleted = false;

  /**
   * Oluşturan kişi
   */
  private String createdBy;

  /**
   * Oluşturulma tarihi
   */
  @Column(nullable = false, updatable = false)
  private LocalDateTime createdDate = LocalDateTime.now();

  /**
   * Güncelleyen kişi
   */
  private String modifiedBy;

  /**
   * Güncellenme tarihi
   */
  private LocalDateTime modifiedDate;

  /**
   * Update edildiğinde otomatik modifiedDate set edelim.
   */
  @PreUpdate
  public void preUpdate() {
    this.modifiedDate = LocalDateTime.now();
  }

}
