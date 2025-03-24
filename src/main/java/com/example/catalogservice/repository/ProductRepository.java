package com.example.catalogservice.repository;

import com.example.catalogservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz del repositorio para operaciones CRUD en productos.
 * 
 * Spring Data JPA proporciona implementaciones automáticas para
 * los métodos de esta interfaz, basados en convenciones de nombres.
 * 
 * JpaRepository proporciona métodos básicos como:
 * - save(entity): Guardar o actualizar una entidad
 * - findById(id): Buscar por ID
 * - findAll(): Listar todos
 * - delete(entity): Eliminar una entidad
 * - etc.
 * 
 * @author Tutorial
 * @version 1.0
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    /**
     * Busca un producto por su código SKU.
     * 
     * Este método es implementado automáticamente por Spring Data JPA,
     * siguiendo la convención de nombres "findBy[NombrePropiedad]".
     * 
     * @param sku El código SKU a buscar
     * @return Optional con el producto si existe, vacío en caso contrario
     */
    Optional<Product> findBySku(String sku);
    
    /**
     * Comprueba si existe un producto con el SKU especificado.
     * 
     * @param sku El código SKU a verificar
     * @return true si existe, false en caso contrario
     */
    boolean existsBySku(String sku);
    
    /**
     * Busca productos por categoría.
     * 
     * @param category La categoría a buscar
     * @return Lista de productos que pertenecen a la categoría
     */
    List<Product> findByCategory(String category);
    
    /**
     * Busca productos cuyo nombre contenga el texto especificado (case insensitive).
     * 
     * La palabra clave "Containing" en el nombre del método crea una 
     * consulta SQL con LIKE %text%, mientras que "IgnoreCase" hace que
     * la búsqueda no sea sensible a mayúsculas/minúsculas.
     * 
     * @param name Texto a buscar en el nombre del producto
     * @return Lista de productos que coinciden con la búsqueda
     */
    List<Product> findByNameContainingIgnoreCase(String name);
} 