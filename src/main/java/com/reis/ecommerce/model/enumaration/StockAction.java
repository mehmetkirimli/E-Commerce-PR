package com.reis.ecommerce.model.enumaration;

public enum StockAction {
  ORDER_DECREASE,      // Sipariş verildi -> stok düştü
  ORDER_ROLLBACK,      // Sipariş ödemesi başarısız -> stok geri geldi
  MANUAL_UPDATE,       // Admin müdahalesi
  SYSTEM_ADJUSTMENT    // otomatik sistem düzeltmesi
}