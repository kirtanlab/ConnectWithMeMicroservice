package com.ConnectWithMe.config;

import com.ConnectWithMe.Domain.ports.input.service.jwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final jwtService jwtservice;

    public SecurityConfiguration(jwtService jwtservice) {
        this.jwtservice = jwtservice;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("security");
        http.csrf(csrf -> csrf.disable())
                .authorizeRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/Auth/v1/api/Login/", "/Auth/v1/api/SignUp/").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .formLogin(formLogin -> formLogin.disable())  // Disable form login
                .httpBasic(httpBasic -> httpBasic.disable())  // Disable HTTP Basic
                .addFilterBefore(new JwtAuthenticationFilter(jwtservice), UsernamePasswordAuthenticationFilter.class);
        System.out.println(http);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authentication -> {
            try {
                return authenticationManager().authenticate(authentication);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }


}
