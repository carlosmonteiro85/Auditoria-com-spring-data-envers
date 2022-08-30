package com.prototipo.audit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.httpBasic()
			.and()
			.authorizeHttpRequests()
            .antMatchers("/h2-console/**").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.csrf().disable();
			http.headers().frameOptions().disable();
		return http.build();
	}
	
	@Bean
	//Criando um usuario em memoria
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder() 
				.username("root") 
				.password("root") 
				.roles("ADM")
				.build();

		return new InMemoryUserDetailsManager(user);
	}

}
