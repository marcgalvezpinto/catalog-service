package com.example.catalogservice.controller;

import com.example.catalogservice.controller.doc.ProductControllerDoc;
import com.example.catalogservice.model.Product;
import com.example.catalogservice.model.response.ApiResponse;
import com.example.catalogservice.model.response.ProductResponse;
import com.example.catalogservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Controlador REST para gestionar productos.
 * Este controlador solo implementa el endpoint para obtener un producto por ID.
 */

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController implements ProductControllerDoc {

    private final ProductService productService;

    @Override
    public ResponseEntity<ApiResponse<ProductResponse>> getProductById(Long id) {
        log.info("REST request para obtener un producto con ID: {}", id);

        return productService.getProductById(id)
                .map(product -> {
                    ProductResponse response = ProductResponse.fromEntity(product);
                    return ResponseEntity.ok(ApiResponse.success("Producto encontrado correctamente", response));
                })
                .orElseThrow(() -> new com.example.catalogservice.exception.ResourceNotFoundException("Producto", "id", id));
    }

    @Override
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getAllProducts() {
        log.info("REST request para obtener todos los productos");

        List<Product> products = productService.getAllProducts();
        List<ProductResponse> responseList = products.stream()
                .map(ProductResponse::fromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                ApiResponse.success("Productos obtenidos correctamente", responseList)
        );
    }

    @Override
    public ResponseEntity<ApiResponse<Void>> deleteProduct(Long id) {
        log.info("REST request para eliminar un producto con ID: {}", id);

        productService.deleteProduct(id);

        return ResponseEntity.ok(
                ApiResponse.success("Producto eliminado correctamente")
        );
    }


}

