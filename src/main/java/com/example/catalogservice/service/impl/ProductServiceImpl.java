package com.example.catalogservice.service.impl;

import com.example.catalogservice.exception.ResourceNotFoundException;
import com.example.catalogservice.model.Product;
import com.example.catalogservice.repository.ProductRepository;
import com.example.catalogservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de productos.
 *
 * Esta clase implementa la interfaz ProductService y proporciona
 * la lógica de negocio para gestionar productos en el catálogo.
 *
 * @author Tutorial
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        log.info("Obteniendo todos los productos");
        return productRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Product> getProductById(Long id) {
        log.info("Buscando producto con ID: {}", id);
        return productRepository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void deleteProduct(Long id) {
        log.info("Eliminando producto con ID: {}", id);

        // Verificamos que el producto exista
        if (!productRepository.existsById(id)) {
            log.error("Producto con ID: {} no encontrado", id);
            throw new ResourceNotFoundException("Producto", "id", id);
        }

        productRepository.deleteById(id);
    }
}
