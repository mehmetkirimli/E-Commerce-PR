package com.reis.ecommerce.common.enumerations;

import lombok.Getter;

@Getter
public enum ResponseStatus {
  SUCCESS(true),
  FAIL(false);

  private final boolean isSuccess;

  ResponseStatus(boolean success) {
    this.isSuccess = success;
  }
}

