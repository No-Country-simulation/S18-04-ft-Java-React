package com.nocountry.nocountry.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@OpenAPIDefinition(
        info = @Info(
                title = "Labor Simulation Management System",
                description = "A system designed to manage tech labor simulations, including user registration, role assignment, team creation, and simulation tracking. Administrators can create simulations and hackathons, and generate skill profiles and CVs.",
                version = "1.0.0",
                contact = @Contact(
                        name = "No Country",
                        url = "https://no-country.up.railway.app/welcome",
                        email = "support@techsimulations.com"
                ),
                license = @License(
                        name = "Standard Software Use License",
                        url = "https://techsimulations.com/license"
                )
        ),
        servers = {
                @Server(description = "Development Server", url = "http://localhost:8090"),
                @Server(description = "Production Server", url = "https://nocountry.up.railway.app")
        },
        security = @SecurityRequirement(name = "bearerAuth")
)
@Configuration
@SecurityScheme(
        name = "bearerAuth",
        description = "Bearer authentication scheme for accessing the API. A valid JWT token is required.",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class OpenAPIConfig implements WebMvcConfigurer {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .packagesToScan("com.nocountry.nocountry")
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/swagger-ui/");
        registry
                .addResourceHandler("/v3/api-docs/**")
                .addResourceLocations("classpath:/META-INF/resources/openapi/");
    }
}
