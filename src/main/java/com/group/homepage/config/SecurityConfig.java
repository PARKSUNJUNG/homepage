package com.group.homepage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((requests)->requests
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/api/**").permitAll()
                        //.requestMatchers("/login").permitAll()
                        //.requestMatchers("/admin/**").authenticated()
                        .anyRequest().authenticated()
                )
                .cors(Customizer.withDefaults());

        return http.build();
    }
}
