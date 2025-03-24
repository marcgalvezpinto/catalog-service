package com.example.catalogservice.controller.doc;

import com.example.catalogservice.model.response.ApiResponse;
import com.example.catalogservice.model.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Interfaz para documentar los endpoints del controlador de productos.
 */
public interface ProductControllerDoc {
    /**
     * Endpoint para obtener todos los productos.
     *
     * @return Lista de todos los productos en el catálogo
     */
    @Operation(
            summary = "Obtener todos los productos",
            description = "Retorna una lista de todos los productos disponibles en el catálogo"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Productos encontrados correctamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProductResponse.class),
                            examples = @ExampleObject(
                                    name = "Ejemplo de respuesta",
                                    value = """
                    {
                        "success": true,
                        "message": "Productos encontrados correctamente",
                        "data": [
                            {
                                "id": 1,
                                "sku": "LAPTOP-001",
                                "name": "Laptop HP Pavilion",
                                "description": "Laptop HP Pavilion con procesador Intel Core i5, 8GB RAM y 512GB SSD",
                                "price": 799.99,
                                "stock": 15,
                                "category": "Electrónica",
                                "createdAt": "2024-03-15T10:30:00"
                            }
                        ]
                    }
                    """
                            )
                    )
            )
    })
    @GetMapping
    ResponseEntity<ApiResponse<List<ProductResponse>>> getAllProducts();


    /**
     * Endpoint para obtener un producto por su ID.
     *
     * @param id ID del producto a buscar
     * @return Producto encontrado o error 404 si no existe
     */
    @Operation(
            summary = "Obtener producto por ID",
            description = "Busca y retorna un producto según su ID"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Producto encontrado correctamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProductResponse.class),
                            examples = @ExampleObject(
                                    name = "Ejemplo de respuesta",
                                    value = """
                    {
                        "success": true,
                        "message": "Producto encontrado correctamente",
                        "data": {
                            "id": 1,
                            "sku": "LAPTOP-001",
                            "name": "Laptop HP Pavilion",
                            "description": "Laptop HP Pavilion con procesador Intel Core i5, 8GB RAM y 512GB SSD",
                            "price": 799.99,
                            "stock": 15,
                            "category": "Electrónica",
                            "createdAt": "2024-03-15T10:30:00"
                        }
                    }
                    """
                            )
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "Producto no encontrado",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Ejemplo de error",
                                    value = """
                    {
                        "success": false,
                        "message": "No se encontró el producto con ID: 999",
                        "data": null
                    }
                    """
                            )
                    )
            )
    })
    @GetMapping("/{id}")
    ResponseEntity<ApiResponse<ProductResponse>> getProductById(
            @Parameter(
                    description = "ID del producto",
                    required = true,
                    example = "1"
            )
            @PathVariable Long id
    );

    /**
     * Endpoint para eliminar un producto.
     *
     * @param id ID del producto a eliminar
     * @return Confirmación de eliminación
     */
    @Operation(
            summary = "Eliminar producto",
            description = "Elimina un producto del catálogo"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Producto eliminado correctamente",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Ejemplo de respuesta",
                                    value = """
                    {
                        "success": true,
                        "message": "Producto eliminado correctamente",
                        "data": null
                    }
                    """
                            )
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "Producto no encontrado",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Ejemplo de error",
                                    value = """
                    {
                        "success": false,
                        "message": "No se encontró el producto con ID: 999",
                        "data": null
                    }
                    """
                            )
                    )
            )
    })
    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse<Void>> deleteProduct(
            @Parameter(
                    description = "ID del producto",
                    required = true,
                    example = "1"
            )
            @PathVariable Long id
    );
}
