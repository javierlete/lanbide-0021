package com.ipartek.formacion.spring.ipartekify30.configuraciones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	// AUTENTICACIÓN
	// https://bcrypt-generator.com/   (10 rounds)
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails admin =
			 User
				.withUsername("javier")
				.password("{bcrypt}$2a$10$Rgv2w4KKA.KOk9PQYTya5OVeCdJVnUJCHQkLj6c/rxubWQVQzrs4W") // lete
				.roles("ADMIN")
				.build();
		UserDetails user =
			 User
				.withUsername("pepe")
				.password("{bcrypt}$2a$10$fw6cwB01Iff/dl1EHS9f1e2xI76mid5vE4C/M2ILIe6zeZO/fTiZ.") // perez
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(admin, user);
	}

	// AUTORIZACIÓN
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				//.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}

}