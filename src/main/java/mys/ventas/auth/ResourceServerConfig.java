package mys.ventas.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/api/**").permitAll()
		.antMatchers("/oauth/token", "/oauth/authorize**", "/publica").permitAll().anyRequest().authenticated();
	}
	
//	@Bean
//	public CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration config = new CorsConfiguration();
//		config.setAllowedOrigins(Arrays.asList("http://localhost:4200","*"));
//		config.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
//		config.setAllowCredentials(true);
//		config.setAllowedHeaders(Arrays.asList("Content-Type","Authorization"));
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		//Para todas las rutas del API
//		source.registerCorsConfiguration("/**", config);
//		return source;
//	}
//	
//	@Bean
//	public FilterRegistrationBean<CorsFilter> corsFilter(){
//		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
//		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//		return bean;
//	}

}
