package com.ozeyranoglucengizhan.library_management_system.handler;

import com.ozeyranoglucengizhan.library_management_system.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ApiError<String>> handleBaseException(BaseException ex, WebRequest request) {
        ApiError<String> apiError = createApiError(ex.getMessage(), request, ex.getStatus().value());
        return ResponseEntity.status(ex.getStatus()).body(apiError);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ApiError<Map<String, List<String>>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, List<String>> map = new HashMap<>();
        for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) objectError).getField();
            if (map.containsKey(fieldName)) {
                map.put(fieldName, addValue(map.get(fieldName), objectError.getDefaultMessage()));
            } else {
                map.put(fieldName, addValue(new ArrayList<>(), objectError.getDefaultMessage()));
            }
        }
        return ResponseEntity.badRequest().body(createApiError(map, request, HttpStatus.BAD_REQUEST.value()));
    }

    private List<String> addValue(List<String> list, String value) {
        list.add(value);
        return list;
    }

    public <E> ApiError<E> createApiError(E message, WebRequest request, Integer status) {
        ApiError<E> apiError = new ApiError<>();
        apiError.setPath(request.getDescription(false).substring(4));
        apiError.setMessage(message);
        apiError.setCreateTime(LocalDate.now());
        apiError.setStatus(status);
        return apiError;
    }
}
