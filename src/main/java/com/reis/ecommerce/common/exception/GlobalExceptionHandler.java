package com.reis.ecommerce.common.exception;

import com.reis.ecommerce.common.enumerations.MessageEnum;
import com.reis.ecommerce.common.response.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(org.springframework.web.servlet.resource.NoResourceFoundException.class)
  public ResponseEntity<ApiResponse<?>> handleNotFound(NoResourceFoundException ex)
  {
    ApiResponse<?> response = new ApiResponse<>(false, "Resource not found", null);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }

  /**
   * ⭐ Validation (@Valid) hataları
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiResponse<?>> handleValidationException(MethodArgumentNotValidException ex)
  {
    Map<String, String> errors = new HashMap<>();

    ex.getBindingResult().getAllErrors().forEach(error -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    log.warn("VALIDATION ERROR: {}", errors);
    return new ResponseEntity<>(ApiResponse.fail(MessageEnum.BAD_REQUEST),HttpStatus.BAD_REQUEST);
  }

  /**
   * ⭐ BusinessException (kendi özel exception sınıfın)
   */
  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ApiResponse<?>> handleBusinessException(BusinessException ex)
  {
    log.warn("BUSINESS ERROR: {}", ex.getMessage());
    return new ResponseEntity<>(ApiResponse.fail(MessageEnum.BAD_REQUEST),HttpStatus.BAD_REQUEST);
  }

  /**
   * ⭐ Entity bulunamadığında
   */
  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ApiResponse<?>> handleEntityNotFound(EntityNotFoundException ex) {

    log.warn("ENTITY NOT FOUND: {}", ex.getMessage());

    return new ResponseEntity<>(
        ApiResponse.fail(MessageEnum.NOT_FOUND),
        HttpStatus.NOT_FOUND
    );
  }

  /**
   * ⭐ Optimistic Lock hatası
   */
  @ExceptionHandler(OptimisticLockingFailureException.class)
  public ResponseEntity<ApiResponse<?>> handleOptimisticLock(OptimisticLockingFailureException ex) {

    log.error("OPTIMISTIC LOCK ERROR → Version conflict!", ex);

    return new ResponseEntity<>(ApiResponse.fail(MessageEnum.CONFLICT),HttpStatus.CONFLICT);
  }

  /**
   * ⭐ Illegal Arguments
   */
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ApiResponse<?>> handleIllegalArgument(IllegalArgumentException ex)
  {
    log.warn("INVALID ARGUMENT: {}", ex.getMessage());
    return new ResponseEntity<>(ApiResponse.fail(MessageEnum.BAD_REQUEST),HttpStatus.BAD_REQUEST );
  }

  /**
   * ⭐ Tüm kontrol edilemeyen hatalar (fallback)
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResponse<?>> handleGlobalException(Exception ex)
  {
    log.error("UNEXPECTED ERROR:", ex);
    return new ResponseEntity<>(ApiResponse.fail(MessageEnum.ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
