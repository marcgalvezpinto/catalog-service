package com.example.catalogservice.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Clase que representa una respuesta estándar de la API.
 * 
 * Esta clase permite estandarizar todas las respuestas de la API
 * para seguir una estructura común, facilitando el manejo de errores
 * y éxitos en el cliente.
 * 
 * La anotación @JsonInclude(JsonInclude.Include.NON_NULL) evita incluir
 * campos con valor null en la respuesta JSON.
 * 
 * @param <T> Tipo de dato que se incluirá en la respuesta
 * @author Tutorial
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    /**
     * Indica si la operación fue exitosa.
     */
    @Builder.Default
    private boolean success = true;
    
    /**
     * Mensaje descriptivo de la respuesta.
     */
    private String message;
    
    /**
     * Datos específicos de la respuesta.
     */
    private T data;
    
    /**
     * Timestamp de la respuesta.
     */
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
    
    /**
     * Código de error (si es aplicable).
     */
    private String errorCode;

    /**
     * Método estático para crear una respuesta exitosa sin datos.
     * 
     * @param message Mensaje descriptivo
     * @return Objeto ApiResponse con éxito
     */
    public static ApiResponse<Void> success(String message) {
        return ApiResponse.<Void>builder()
                .success(true)
                .message(message)
                .build();
    }

    /**
     * Método estático para crear una respuesta exitosa con datos.
     * 
     * @param <T> Tipo de dato de la respuesta
     * @param message Mensaje descriptivo
     * @param data Datos de la respuesta
     * @return Objeto ApiResponse con éxito y datos
     */
    public static <T> ApiResponse<T> success(String message, T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .build();
    }

    /**
     * Método estático para crear una respuesta de error.
     * 
     * @param <T> Tipo de dato de la respuesta
     * @param message Mensaje de error
     * @param errorCode Código de error
     * @return Objeto ApiResponse con error
     */
    public static <T> ApiResponse<T> error(String message, String errorCode) {
        return ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .errorCode(errorCode)
                .build();
    }
} 