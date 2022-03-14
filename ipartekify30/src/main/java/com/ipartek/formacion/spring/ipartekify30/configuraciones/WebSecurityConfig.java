package com.ipartek.formacion.spring.ipartekify30.configuraciones;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ipartek.formacion.spring.ipartekify30.entidades.Usuario;
import com.ipartek.formacion.spring.ipartekify30.servicios.IpartekifyService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private IpartekifyService servicio;
	
	// AUTENTICACIÓN
	// https://bcrypt-generator.com/   (10 rounds)
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
	  throws Exception {
	    auth.jdbcAuthentication()
	      .dataSource(dataSource)
	      .usersByUsernameQuery("select email,password,1 "
	        + "from usuarios "
	        + "where email = ?")
	      .authoritiesByUsernameQuery("select email,CONCAT('ROLE_', rol) "
	        + "from usuarios "
	        + "where email = ?")
	      .passwordEncoder(new BCryptPasswordEncoder());
	}
	
	// AUTORIZACIÓN
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/favicon.ico").permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.successHandler((request, response, authentication) -> {
					Usuario usuario = servicio.obtenerUsuarioPorEmail(authentication.getName());
					
					request.getSession().setAttribute("usuario", usuario);
					
					response.sendRedirect("/");
				})
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}

}