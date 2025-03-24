# Catálogo de Productos - Microservicio Spring Boot

Este proyecto es un microservicio de catálogo de productos desarrollado con Spring Boot, diseñado con fines educativos para aprender las mejores prácticas en el desarrollo de APIs RESTful.

## Requisitos Previos

- Java 21
- Maven
- IDE (recomendado: VS Code, IntelliJ IDEA o Eclipse)
- Postman (opcional, para pruebas de API)

## Tecnologías Utilizadas

- Spring Boot 3.x
- Spring Data JPA
- H2 Database (base de datos en memoria)
- Swagger/OpenAPI para documentación
- Lombok para reducción de código boilerplate
- Jakarta Bean Validation

## Guía de Aprendizaje

### 1. Estructura del Proyecto
Familiarízate con la estructura del proyecto:
```
src/main/java/com/example/catalogservice/
├── CatalogServiceApplication.java
├── controller/
│   ├── ProductController.java
│   └── doc/
│       └── ProductControllerDoc.java
├── model/
│   ├── Product.java
│   └── response/
│       ├── ApiResponse.java
│       └── ProductResponse.java
├── repository/
│   └── ProductRepository.java
├── service/
│   ├── ProductService.java
│   └── impl/
│       └── ProductServiceImpl.java
└── exception/
    ├── ResourceNotFoundException.java
    └── GlobalExceptionHandler.java
```

### 2. Conceptos Clave (Estudiar en este orden)

1. **Modelo de Datos (`model/`)**
   - Estudia `Product.java` para entender:
     - Anotaciones JPA para mapeo objeto-relacional
     - Validaciones con Jakarta Bean Validation
     - Uso de Lombok para reducir código boilerplate
     - Clases de respuesta estandarizadas (ApiResponse, ProductResponse)

2. **Capa de Repositorio (`repository/`)**
   - Analiza `ProductRepository.java`:
     - Interfaz JpaRepository y sus métodos predefinidos
     - Consultas personalizadas con Query Methods

3. **Capa de Servicio (`service/`)**
   - Revisa en orden:
     - `ProductService.java`: Definición de la interfaz del servicio
     - `ProductServiceImpl.java`: Implementación de la lógica de negocio
     - Manejo de transacciones
     - Mapeo entre entidades y DTOs

4. **Manejo de Excepciones (`exception/`)**
   - Estudia:
     - `ResourceNotFoundException.java`: Excepción personalizada
     - `GlobalExceptionHandler.java`: Manejo centralizado de excepciones
     - Respuestas de error estandarizadas

5. **Capa de Controlador (`controller/`)**
   - Analiza en orden:
     - `ProductControllerDoc.java`: Documentación de la API con Swagger
     - `ProductController.java`: Implementación de endpoints REST
     - Validación de entrada
     - Manejo de respuestas HTTP

### 3. Características de la API

Practica con los siguientes endpoints:

1. **Operaciones CRUD Básicas**
   - GET `/api/products`: Listar todos los productos
   - GET `/api/products/{id}`: Obtener producto por ID
   - POST `/api/products`: Crear nuevo producto
   - PUT `/api/products/{id}`: Actualizar producto
   - DELETE `/api/products/{id}`: Eliminar producto

2. **Búsquedas Especializadas**
   - GET `/api/products/sku/{sku}`: Buscar por SKU
   - GET `/api/products/category/{category}`: Filtrar por categoría
   - GET `/api/products/search?name=`: Buscar por nombre

### 4. Documentación Swagger

1. Accede a la documentación Swagger:
   - URL: `http://localhost:8080/api/swagger-ui.html`
   - Explora los endpoints disponibles
   - Revisa los ejemplos de solicitud y respuesta
   - Prueba los endpoints directamente desde la interfaz

### 5. Base de Datos

1. Accede a la consola H2:
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:catalogdb`
   - Usuario: `sa`
   - Contraseña: (dejar en blanco)

2. Explora:
   - Estructura de la tabla `products`
   - Datos precargados desde `data.sql`
   - Ejecuta consultas SQL personalizadas

### 6. Ejercicios Prácticos Sugeridos

1. **Nivel Básico**
   - Listar todos los productos
   - Buscar un producto por ID
   - Crear un nuevo producto
   - Actualizar un producto existente
   - Eliminar un producto

2. **Nivel Intermedio**
   - Implementar paginación en el listado de productos
   - Agregar ordenamiento por diferentes campos
   - Crear nuevos endpoints de búsqueda (por precio, rango de fechas)

3. **Nivel Avanzado**
   - Agregar nuevas validaciones personalizadas
   - Implementar caché para las consultas frecuentes
   - Crear pruebas unitarias y de integración
   - Agregar autenticación y autorización

## Ejecución del Proyecto

1. Clona el repositorio:
```bash
git clone [URL_DEL_REPOSITORIO]
```

2. Navega al directorio del proyecto:
```bash
cd catalogservice
```

3. Ejecuta la aplicación:
```bash
mvn spring-boot:run
```

4. Accede a:
   - API: `http://localhost:8080/api/products`
   - Swagger UI: `http://localhost:8080/swagger-ui.html`
   - H2 Console: `http://localhost:8080/h2-console`

## Recursos Adicionales

- [Documentación de Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Guía de JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [Documentación de Swagger/OpenAPI](https://swagger.io/docs/)
- [Tutorial de Lombok](https://projectlombok.org/features/all)

## Contribución

Si encuentras algún error o tienes sugerencias de mejora, por favor crea un issue o envía un pull request.

## Licencia

Este proyecto está bajo la licencia MIT. Ver el archivo `LICENSE` para más detalles. 