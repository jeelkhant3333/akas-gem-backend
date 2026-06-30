package com.techspine.diamond.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;
import java.util.List;

@Configuration
public class AppConfig {

    @Value("${app.url}")
    private String appURL;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {

        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(
                        config -> config.configurationSource(request -> {

                            CorsConfiguration cfg = new CorsConfiguration();

                            cfg.setAllowedOrigins(List.of(appURL));
                            cfg.setAllowedMethods(Collections.singletonList("*"));
                            cfg.setAllowCredentials(true);
                            cfg.setAllowedHeaders(Collections.singletonList("*"));
                            cfg.setExposedHeaders(List.of("Authorization"));
                            cfg.setMaxAge(3600L);
                            return cfg;
                        }))
                .build();

    }
}
