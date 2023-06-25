package com.midefensa.midefensaapp.security.config;

import com.midefensa.midefensaapp.security.jwt.JwtAuthenticationFilter;
import com.midefensa.midefensaapp.utility.enums.RolUsuarioEnum;
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
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf()
            .disable()
            .authorizeHttpRequests()
            .requestMatchers("/midefensa/autenticacion/**",
                    "/midefensa/persona/guardarPersona",
                    "/midefensa/ciudad/obtenerTodasLasCiudades",
                    "/midefensa/ciudad/obtenerTodasLasCiudadesActivas",
                    "/midefensa/ciudad/obtenerTodasLasCiudadesPorDepartamentoId/**",
                    "/midefensa/ciudad/buscarCiudadPorId/**",
                    "/midefensa/ciudad/buscarCiudadPorIdActiva/**",
                    "/midefensa/ciudad/buscarCiudadPorNombre/**",
                    "/midefensa/ciudad/buscarCiudadPorNombreActiva/**",
                    "/midefensa/departamento/obtenerTodosLosDepartamentos",
                    "/midefensa/departamento/obtenerTodosLosDepartamentosActivos",
                    "/midefensa/departamento/buscarDepartamentoPorId/**",
                    "/midefensa/departamento/buscarDepartamentoPorIdActivo/**",
                    "/midefensa/departamento/buscarDepartamentoPorNombre/**",
                    "/midefensa/departamento/buscarDepartamentoPorNombreActivo/**")
            .permitAll()
            .requestMatchers("/midefensa/ciudad/**",
                    "/midefensa/credencial/**",
                    "/midefensa/departamento/**",
                    "/midefensa/persona/**",
                    "/midefensa/tipoDocumento/**").hasAnyAuthority(RolUsuarioEnum.ADMINISTRADOR.name())
            .anyRequest()
            .authenticated()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
