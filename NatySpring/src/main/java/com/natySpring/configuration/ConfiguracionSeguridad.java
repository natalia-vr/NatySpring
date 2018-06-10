package com.natySpring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/*
 * para la configuracion que no se puede añadir al application.yml , tenemos que crear clases
 * que nos configuren nuestra aplicacion en el paquete configuration
 * 
 * */

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

	// cargamos el servicio servicioUsuarioImpl
	@Autowired
	@Qualifier("servicioUsuarioImpl")
	private UserDetailsService serviciosUsuario;

	// sobreescribimos el metodo configureGlobal()
	// nos sirve para añadir el 'UserDetailsService' que hemos creado
	// BCryptPasswordEncoder() es el encargado de cifrar la contraseña para meterla
	// en base de datos
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auto) throws Exception {
		
		auto.userDetailsService(serviciosUsuario).passwordEncoder(new BCryptPasswordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() // indica los que estan autorizados sin necesidad de un login
			.antMatchers("/css/*" ,"/imgs/*") // indicamos que se pueden cargar todos los recursos estaticos que tengamos
			.permitAll() // permitir a todos
			.anyRequest() //el resto de requests
			.authenticated() // autentificacion necesria
			
		.and() // y
		
		.formLogin() // formulario de login
			.loginPage("/login") // pagina de login
			.loginProcessingUrl("/comprobarlogin") // url que procesa el login
			
			.usernameParameter("usuarioForm") // parametro nombre del usuario en el formulario
			.passwordParameter("contrasenaForm") // parametro nombre del contraseña en el formulario
			.defaultSuccessUrl("logincorrecto") // url a la que se redirige si el login es correcto
			.permitAll() // permitir a todos
			
		.and() // y
		
		.logout() //logout
			.logoutUrl("/cerrarsesion") // url de logout
			.logoutSuccessUrl("/login?logout")  //  url a la que se redirige : ira a /login con parametro ?logout
			.permitAll(); // permitir a todos		
	}


}
