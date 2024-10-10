package com.capgemini.genai.clinicaldecision.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Desabilitar CSRF e permitir todas as requisições
        http.csrf().disable()
                .authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());  // Permite todas as requisições sem autenticação
        return http.build();
    }
}
