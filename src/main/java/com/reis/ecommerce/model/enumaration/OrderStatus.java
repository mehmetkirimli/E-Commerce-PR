package com.reis.ecommerce.model.enumaration;

public enum OrderStatus {
  CREATED,        // Sipariş oluşturuldu
  PENDING,        // Sipariş oluşturuldu ama ödeme alınmadı
  PAID,           // Ödeme başarılı
  CANCELLED,      // Kullanıcı/sistem iptal etti
  FAILED,         // Ödeme başarısız
  SHIPPED,        // Kargoya verildi
  COMPLETED       // Müşteriye teslim edildi
}