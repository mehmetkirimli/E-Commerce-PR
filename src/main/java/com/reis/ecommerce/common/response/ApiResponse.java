package com.reis.ecommerce.common.response;


import com.reis.ecommerce.common.enumerations.MessageEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

  private boolean success;
  private String message;
  private T data;

  public static <T> ApiResponse<T> success(T data) {
    return ApiResponse.<T>builder()
        .success(true)
        .message(MessageEnum.SUCCESS.getMessage())
        .data(data)
        .build();
  }

  public static <T> ApiResponse<T> success(T data, MessageEnum msg) {
    return ApiResponse.<T>builder()
        .success(true)
        .message(msg.getMessage())
        .data(data)
        .build();
  }

  public static <T> ApiResponse<T> fail(MessageEnum msg) {
    return ApiResponse.<T>builder()
        .success(false)
        .message(msg.getMessage())
        .data(null)
        .build();
  }
}
