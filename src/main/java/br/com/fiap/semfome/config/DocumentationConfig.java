package br.com.fiap.semfome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class DocumentationConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
            .info(new Info()
                .title("Sem Fome - GS Grupo Atlas")
                .version("V1")
                .description("Api para cadastro de alimentos.")
                .contact(new Contact().name("Samuel").email("rm92848@fiap.com.br"))
            )
            .components(new Components()
                .addSecuritySchemes("bearer-key",
                    new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer")
                    .bearerFormat("JWT")));
    }
    
}