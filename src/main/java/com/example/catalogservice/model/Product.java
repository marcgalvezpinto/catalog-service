package com.example.catalogservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Clase que representa un producto en el catálogo.
 * 
 * Esta entidad se mapea directamente a una tabla en la base de datos
 * utilizando las anotaciones de JPA (Java Persistence API).
 * 
 * Se utiliza Lombok para reducir el código boilerplate:
 * - @Data: Genera getters, setters, equals, hashCode y toString
 * - @Builder: Implementa el patrón Builder para crear objetos
 * - @NoArgsConstructor: Constructor sin argumentos (requerido por JPA)
 * - @AllArgsConstructor: Constructor con todos los argumentos
 * 
 * @author Tutorial
 * @version 1.0
 */
@Entity
@Table(name = "products")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    /**
     * Identificador único del producto.
     * Se genera automáticamente con una estrategia de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Código SKU (Stock Keeping Unit) único del producto.
     * No puede estar vacío y debe ser único en la base de datos.
     */
    @NotBlank(message = "El código de producto es obligatorio")
    @Size(min = 3, max = 50, message = "El código debe tener entre 3 y 50 caracteres")
    @Column(unique = true, nullable = false)
    private String sku;

    /**
     * Nombre del producto.
     * No puede estar vacío.
     */
    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(nullable = false)
    private String name;

    /**
     * Descripción detallada del producto.
     */
    @Column(length = 2000)
    private String description;

    /**
     * Precio del producto.
     * Debe ser un valor positivo.
     */
    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor que cero")
    @Column(nullable = false)
    private BigDecimal price;

    /**
     * Cantidad de stock disponible.
     */
    @NotNull(message = "El stock es obligatorio")
    @Builder.Default
    private Integer stock = 0;

    /**
     * Categoría a la que pertenece el producto.
     */
    private String category;

    /**
     * Fecha y hora de creación del registro.
     * Se establece automáticamente al crear el objeto.
     */
    @Column(name = "created_at", updatable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    /**
     * Fecha y hora de la última actualización del registro.
     * Se actualiza automáticamente cada vez que se modifica el objeto.
     */
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /**
     * Método que se ejecuta antes de persistir o actualizar la entidad.
     * Actualiza el campo updatedAt con la fecha y hora actual.
     */
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
} 