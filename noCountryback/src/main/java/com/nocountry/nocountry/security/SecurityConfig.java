package com.nocountry.nocountry.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final static String OAUTH2_BASE_URI = "/api/auth/oauth2/authorize";
    private final static String OAUTH2_REDIRECTION_ENDPOINT = "/oauth2/callback/*";

    private static final String[] AUTH_ENDPOINTS_PUBLIC = {
            "/api/auth/login",
            "/api/auth/greet",
            "/api/auth/register",
            "/api/auth/check-login",
            "/api/auth/login/oauth",
    };

}
