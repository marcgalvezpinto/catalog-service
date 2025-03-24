-- Archivo de datos iniciales para la base de datos H2
-- Este archivo se ejecuta automáticamente al iniciar la aplicación cuando
-- spring.jpa.hibernate.ddl-auto está configurado como 'create' o 'create-drop'

-- Inserción de productos de ejemplo
INSERT INTO products (sku, name, description, price, stock, category, created_at)
VALUES 
('LAPTOP-001', 'Laptop HP Pavilion', 'Laptop HP Pavilion con procesador Intel Core i5, 8GB RAM y 512GB SSD', 799.99, 15, 'Electrónica', CURRENT_TIMESTAMP()),
('PHONE-001', 'Smartphone Samsung Galaxy S21', 'Smartphone Samsung Galaxy S21 con pantalla 6.2", 128GB almacenamiento', 699.99, 25, 'Electrónica', CURRENT_TIMESTAMP()),
('BOOK-001', 'El Señor de los Anillos', 'Trilogía completa de J.R.R. Tolkien en tapa dura', 49.99, 30, 'Libros', CURRENT_TIMESTAMP()),
('BOOK-002', 'Cien Años de Soledad', 'Novela de Gabriel García Márquez, edición conmemorativa', 24.99, 20, 'Libros', CURRENT_TIMESTAMP()),
('FOOD-001', 'Café Gourmet', 'Café gourmet de Colombia, paquete de 500g', 12.99, 50, 'Alimentación', CURRENT_TIMESTAMP()),
('KITCHEN-001', 'Batidora Eléctrica', 'Batidora eléctrica de 5 velocidades con accesorios', 89.99, 10, 'Hogar', CURRENT_TIMESTAMP()),
('FURN-001', 'Silla de Oficina Ergonómica', 'Silla de oficina ergonómica con soporte lumbar ajustable', 199.99, 5, 'Muebles', CURRENT_TIMESTAMP()),
('GAME-001', 'PlayStation 5', 'Consola PlayStation 5 con un control inalámbrico', 499.99, 3, 'Videojuegos', CURRENT_TIMESTAMP()),
('GAME-002', 'FIFA 2023', 'Videojuego FIFA 2023 para PlayStation 5', 59.99, 12, 'Videojuegos', CURRENT_TIMESTAMP()),
('CLOTH-001', 'Camiseta Algodón Premium', 'Camiseta de algodón 100% premium, talla M', 19.99, 40, 'Ropa', CURRENT_TIMESTAMP()); 