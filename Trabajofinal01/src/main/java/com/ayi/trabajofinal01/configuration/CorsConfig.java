package com.ayi.trabajofinal01.configuration;


import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuración de Cross-Origin Resource Sharing (CORS) para permitir solicitudes
 * desde un origen específico (http://localhost:3000/ en este caso).
 *
 * Esta configuración utiliza la anotación {@link Configuration} y proporciona un bean
 * de tipo {@link WebMvcConfigurer} para configurar políticas CORS en la aplicación.
 *
 * @see WebMvcConfigurer
 */
@Getter
@Configuration
public class CorsConfig {

    /**
     * Bean que configura las políticas CORS para permitir solicitudes desde
     * http://localhost:3000/ y especifica los métodos permitidos (GET, POST, PUT, DELETE).
     *
     * @return Instancia de {@link WebMvcConfigurer} con la configuración CORS.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000/")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .maxAge(3600);
            }
        };
    }
}