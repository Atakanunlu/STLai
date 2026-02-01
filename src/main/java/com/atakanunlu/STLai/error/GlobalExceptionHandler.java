package com.atakanunlu.STLai.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequest(BadRequestException exception){
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, exception.getMessage());
        log.error(apiError.toString(),exception);
        return ResponseEntity.status(apiError.status()).body(apiError);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFound(ResourceNotFoundException exception){
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,
                exception.getResourceName()+" with id: "+exception.getResourceId() + " not found.");
        log.error(apiError.toString(),exception);
        return ResponseEntity.status(apiError.status()).body(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleInputValidationError(MethodArgumentNotValidException exception){

        List<ApiFiledError> errors = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> new ApiFiledError(error.getField(),error.getDefaultMessage())).toList();

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Input validation failed ",errors);
        log.error(apiError.toString(),exception);
        return ResponseEntity.status(apiError.status()).body(apiError);
    }


}
