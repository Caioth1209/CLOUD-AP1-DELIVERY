package com.cloudap1delivery.cloudap1delivery;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
    
@Configuration
public class ApiDocumentationConfiguration { 

    @Bean
    public OpenAPI apiDocConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("IBMEC - AP1 CLOUD COMPUTING")
                        .description("Ap1 de Cloud Computing - Caio Araujo da Luz")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Caio Araujo da Luz")
                                .email("caiodaluz2004@gmail.com")));
    }
}
