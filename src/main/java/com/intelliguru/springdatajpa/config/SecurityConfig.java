//package com.intelliguru.springdatajpa.config;
//
//import com.intelliguru.springdatajpa.service.UserDetailsServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final UserDetailsServiceImpl userDetailsService;
//
//    // Constructor injection to avoid circular dependency
//    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(request -> request
//                        .requestMatchers("/public/**").permitAll()  // Open for all users
//                        .requestMatchers("/user/**").authenticated()  // Authenticated users only
//                        .requestMatchers("/admin/**").hasRole("ADMIN")  // Only users with 'ADMIN' role
//                        .requestMatchers("/h2-console/**").permitAll()
//                        .anyRequest().authenticated())  // All other requests require authentication
//                .httpBasic(Customizer.withDefaults())  // Basic HTTP Authentication
//                .csrf(csrf -> csrf.disable());  // Disable CSRF for simplicity (if needed)
//
//        return http.build();
//    }
//
//    // Authentication configuration
//    @Bean
//    public AuthenticationManager authenticationManager() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//
//        return new ProviderManager(authenticationProvider);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
