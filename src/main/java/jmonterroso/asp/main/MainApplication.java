package jmonterroso.asp.main; // Asegúrate de que el paquete sea correcto

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import jmonterroso.asp.main.Repository.ProductoRepository;
import jmonterroso.asp.main.Models.Producto;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(ProductoRepository repository) {
        return args -> {
            repository.save(new Producto("Producto A", "Descripción A", 10.99, "disponible"));
            repository.save(new Producto("Producto B", "Descripción B", 20.99, "agotado"));
        };
    }
}