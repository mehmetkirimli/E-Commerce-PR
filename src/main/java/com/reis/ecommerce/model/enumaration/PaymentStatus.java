package com.reis.ecommerce.model.enumaration;

public enum PaymentStatus {
  PENDING,        // Ödeme başlatıldı
  SUCCESS,        // Ödeme başarıyla tamamlandı
  FAILED,         // Ödeme başarısız
  CANCELLED,      // Kullanıcı iptal etti
  REFUNDED        // İade edildi
}