package com.example.catalogservice.exception;

import com.example.catalogservice.model.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Manejador global de excepciones para la API.
 * 
 * Esta clase captura las excepciones lanzadas durante la ejecución de la aplicación
 * y las convierte en respuestas HTTP adecuadas, siguiendo el formato estándar
 * definido en ApiResponse.
 * 
 * La anotación @RestControllerAdvice actúa como un interceptor de excepciones
 * para todos los controladores.
 * 
 * @author Tutorial
 * @version 1.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * Maneja las excepciones de tipo ResourceNotFoundException.
     * 
     * @param ex La excepción capturada
     * @return Respuesta HTTP con estado 404 y detalles del error
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        log.error("Recurso no encontrado: {}", ex.getMessage());
        
        ApiResponse<Object> response = ApiResponse.error(
                ex.getMessage(),
                "RESOURCE_NOT_FOUND"
        );
        
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    /**
     * Maneja las excepciones de tipo IllegalArgumentException.
     * 
     * @param ex La excepción capturada
     * @return Respuesta HTTP con estado 400 y detalles del error
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<Object>> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("Argumento inválido: {}", ex.getMessage());
        
        ApiResponse<Object> response = ApiResponse.error(
                ex.getMessage(),
                "INVALID_ARGUMENT"
        );
        
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Maneja las excepciones de validación de campos.
     * 
     * @param ex La excepción de validación
     * @return Respuesta HTTP con estado 400 y mapa de errores por campo
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        log.error("Error de validación: {}", ex.getMessage());
        
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        
        ApiResponse<Map<String, String>> response = ApiResponse.error(
                "Error de validación en los datos enviados",
                "VALIDATION_ERROR"
        );
        response.setData(errors);
        
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Maneja cualquier otra excepción no contemplada específicamente.
     * 
     * @param ex La excepción general
     * @return Respuesta HTTP con estado 500 y detalles del error
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGlobalException(Exception ex) {
        log.error("Error no controlado: {}", ex.getMessage(), ex);
        
        ApiResponse<Object> response = ApiResponse.error(
                "Ha ocurrido un error inesperado",
                "INTERNAL_SERVER_ERROR"
        );
        
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
} 