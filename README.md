# Proyecto Spring Boot para react

Este proyecto es una aplicación Spring Boot que proporciona una API REST y una aplicación React que consume esta API.

## Requisitos

- Java 21
- Maven

## Configuración del Backend (Spring Boot)

1. Clona el repositorio:
    ```sh
    git clone https://github.com/tu-usuario/tu-repositorio.git
    cd tu-repositorio
    ```

2. Configura la base de datos en el archivo `application.properties`:
    ```properties
    spring.datasource.url=h2:mem:nombre-base-datos
    spring.datasource.username=tu-usuario
    spring.datasource.password=tu-contraseña
    ```

3. Ejecuta la aplicación Spring Boot:
    ```sh
    mvn spring-boot:run
    ```

La aplicación Spring Boot se ejecutará en `http://localhost:8080`.

## Acceso a la API

La API REST está disponible en `http://localhost:8080/productos`.

### Endpoints disponibles

- `GET /api/productos`: Obtiene todos los productos.
- `POST /api/productos`: Crea un nuevo producto.
- `GET /api/productos/{id}`: Obtiene un producto por su ID.
- `PUT /api/productos/{id}`: Actualiza un producto por su ID.
- `DELETE /api/productos/{id}`: Elimina un producto por su ID.

## Configuración de CORS

El archivo `WebConfig.java` está configurado para permitir solicitudes CORS desde `http://localhost:5173`. Si tu aplicación React se ejecuta en un puerto diferente, asegúrate de actualizar esta configuración.

```java
package jmonterroso.asp.main.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173") // Cambia esto al origen de tu aplicación React
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}