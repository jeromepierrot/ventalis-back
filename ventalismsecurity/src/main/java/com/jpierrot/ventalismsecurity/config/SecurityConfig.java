package com.jpierrot.ventalismsecurity.config;

import com.jpierrot.ventalismsecurity.api.ApiRouter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // TODO: ** PRODUCTION - IMPORTANT ** => réactiver la configuration csrf pour la production
        // TODO: ** PRODUCTION - IMPORTANT ** => configurer CORS
        http
                .httpBasic().disable()
                .csrf().disable()
                .cors().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/auth/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .cors().disable()
        ;
        /*http
                .csrf().disable()
                .cors().disable()
                .httpBasic().disable()
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/resources/**", "/signup", "/about").permitAll()
                        .requestMatchers("/api/v1/login/**").hasRole("USER")
                        .requestMatchers("/api/v1/admin/**").access(AuthorizationManagers.anyOf(AuthorityAuthorizationManager.hasRole("ADMIN"), AuthorityAuthorizationManager.hasRole("EMPLOYEE")))
                        .anyRequest().denyAll()
                );*/

        return http.build();
    }
}
