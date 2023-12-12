package com.example.figureCollection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.figureCollection.services.MyUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class SpringSecurityConfig  {

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
    @Bean
    public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        return authenticationManagerBuilder.build();
    }

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //http.authorizeHttpRequests().anyRequest().permitAll();
        http.authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/", "/css/**", "/js/**", "/images/**", "/login").permitAll()
                        .anyRequest().authenticated()
        )
                .formLogin(login -> login
                        .loginPage("/login")
                        .permitAll());
		
		return http.build();
    }
	
}
