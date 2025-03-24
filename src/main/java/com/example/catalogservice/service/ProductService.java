package com.example.catalogservice.service;

import com.example.catalogservice.model.Product;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz para el servicio de productos.
 *
 * Esta interfaz define el contrato de operaciones disponibles
 * para gestionar productos en el catálogo.
 *
 * @author Tutorial
 * @version 1.0
 */
public interface ProductService {

    /**
     * Busca un producto por su ID.
     *
     * @param id ID del producto a buscar
     * @return Optional con el producto si existe, vacío en caso contrario
     */
    Optional<Product> getProductById(Long id);

    List<Product> getAllProducts();

    void deleteProduct(Long id);

}
