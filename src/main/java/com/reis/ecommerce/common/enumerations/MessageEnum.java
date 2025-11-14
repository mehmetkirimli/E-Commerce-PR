package com.reis.ecommerce.common.enumerations;

import lombok.Getter;

@Getter
public enum MessageEnum {

  SUCCESS("Success"),
  SAVED("Record saved successfully"),
  UPDATED("Record updated successfully"),
  DELETED("Record deleted successfully"),

  NOT_FOUND("Record not found"),
  ERROR("Unexpected error occurred"),
  UNAUTHORIZED("You are not authorized"),
  BAD_REQUEST("Bad request"),
  ALREADY_EXISTS("Record already exists"),

  STOCK_NOT_AVAILABLE("Stock not available"),
  CART_EMPTY("Cart is empty"),
  PAYMENT_FAILED("Payment failed");

  private final String message;

  MessageEnum(String message) {
    this.message = message;
  }
}
