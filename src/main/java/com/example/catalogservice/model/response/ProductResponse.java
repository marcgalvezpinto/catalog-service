package com.example.catalogservice.model.response;

import com.example.catalogservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO (Data Transfer Object) para enviar información de productos a los clientes.
 * 
 * Esta clase representa la estructura de datos que se enviará como respuesta
 * en las peticiones relacionadas con productos. Separar la entidad de base de datos
 * de los objetos de transferencia nos permite:
 * 
 * - Desacoplar el modelo de base de datos de la API pública
 * - Controlar qué campos son visibles para los clientes
 * - Optimizar la transferencia de datos (serializando solo lo necesario)
 * 
 * @author Tutorial
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    /**
     * Identificador único del producto.
     */
    private Long id;
    
    /**
     * Código SKU (Stock Keeping Unit) único del producto.
     */
    private String sku;
    
    /**
     * Nombre del producto.
     */
    private String name;
    
    /**
     * Descripción detallada del producto.
     */
    private String description;
    
    /**
     * Precio del producto.
     */
    private BigDecimal price;
    
    /**
     * Cantidad de stock disponible.
     */
    private Integer stock;
    
    /**
     * Categoría a la que pertenece el producto.
     */
    private String category;
    
    /**
     * Fecha y hora de creación del registro.
     */
    private LocalDateTime createdAt;
    
    /**
     * Fecha y hora de la última actualización del registro.
     */
    private LocalDateTime updatedAt;

    /**
     * Método estático para convertir una entidad Product a un objeto ProductResponse.
     * Este patrón facilita la conversión entre la entidad y el DTO.
     * 
     * @param product Entidad producto a convertir
     * @return Objeto ProductResponse con los datos del producto
     */
    public static ProductResponse fromEntity(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .sku(product.getSku())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .category(product.getCategory())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }
} 