package com.mantenimiento.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mantenimiento.security.CustomUserDetailsService;
import com.mantenimiento.security.JwtFilter;

import lombok.AllArgsConstructor;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	 @Autowired
	    private CustomUserDetailsService customUserDetailsService;

	   @Autowired
	    private JwtFilter jwtFilter;
	    
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.mantenimiento"))
				.paths(PathSelectors.any())
				.build();
	}
	
	  @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		  http
          .cors() // Habilita CORS
          .and()
          .csrf().disable()
          .authorizeRequests()
              .antMatchers("/auth/login").permitAll()
              .anyRequest().authenticated()
              .and()
          .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

      http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
      return http.build();
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    /*@Bean
	    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
	        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	        manager.createUser(User.withUsername("admin")
	                .password(passwordEncoder.encode("admin123"))
	                .roles()
	                .build());
	        return manager;
	    }*/
	    
	    @Bean
	    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
	        return http.getSharedObject(AuthenticationManagerBuilder.class)
	                .userDetailsService(customUserDetailsService)
	                .passwordEncoder(passwordEncoder())
	                .and()
	                .build();
	    }
	    
}


