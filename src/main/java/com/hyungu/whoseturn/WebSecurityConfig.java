package com.hyungu.whoseturn;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain servletSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        (requests) ->
                                requests.requestMatchers("/")
                                        .permitAll()
                                        .anyRequest()
                                        .authenticated()
                )
                .formLogin(
                        (from) ->
                                from.loginPage("/login")
                                        .permitAll()
                )
                .logout(
                        (logout) ->
                                logout.permitAll()
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User
                .withDefaultPasswordEncoder()
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
