package com.example.catalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que inicia la aplicación Spring Boot.
 * 
 * Spring Boot simplifica la creación de aplicaciones basadas en Spring mediante:
 * - Configuración automática basada en dependencias
 * - Servidor embebido (Tomcat por defecto)
 * - Métricas y monitoreo integrados
 * 
 * La anotación @SpringBootApplication combina:
 * - @Configuration: Marca la clase como fuente de definiciones de beans
 * - @EnableAutoConfiguration: Habilita la configuración automática basada en dependencias
 * - @ComponentScan: Escanea componentes en el paquete actual y sus subpaquetes
 * 
 * @author Tutorial
 * @version 1.0
 */
@SpringBootApplication
public class CatalogServiceApplication {

    /**
     * Método principal que inicia la aplicación Spring Boot.
     * Este método es el punto de entrada de la aplicación Java.
     * 
     * @param args Argumentos de línea de comandos
     */
    public static void main(String[] args) {
        SpringApplication.run(CatalogServiceApplication.class, args);
    }
} 