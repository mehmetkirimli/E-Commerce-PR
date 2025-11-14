package com.reis.ecommerce.common.response;


import com.reis.ecommerce.common.enumerations.MessageEnum;

public class ResponseFactory {

  public static <T> ApiResponse<T> ok(T data) {
    return ApiResponse.success(data);
  }

  public static <T> ApiResponse<T> ok(T data, MessageEnum message) {
    return ApiResponse.success(data, message);
  }

  public static <T> ApiResponse<T> fail(MessageEnum message) {
    return ApiResponse.fail(message);
  }
}
