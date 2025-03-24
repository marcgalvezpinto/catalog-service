package com.example.catalogservice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción personalizada para recursos no encontrados.
 * 
 * Esta excepción se lanza cuando se intenta acceder a un recurso
 * que no existe en la base de datos. La anotación @ResponseStatus
 * hace que Spring Boot genere automáticamente una respuesta HTTP
 * con el estado 404 NOT_FOUND cuando se lance esta excepción.
 * 
 * @author Tutorial
 * @version 1.0
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Nombre del recurso que no se encontró (ej: "Producto").
     */
    private final String resourceName;
    
    /**
     * Nombre del campo por el que se buscó (ej: "id").
     */
    private final String fieldName;
    
    /**
     * Valor del campo con el que se buscó (ej: 123).
     */
    private final Object fieldValue;

    /**
     * Constructor para crear una excepción de recurso no encontrado.
     * 
     * @param resourceName Nombre del recurso
     * @param fieldName Nombre del campo
     * @param fieldValue Valor del campo
     */
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        // Formateamos un mensaje descriptivo para la excepción
        super(String.format("%s no encontrado con %s: '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
} 