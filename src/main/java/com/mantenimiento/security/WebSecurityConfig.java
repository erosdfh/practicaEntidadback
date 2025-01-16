package com.mantenimiento.security;
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

/*import com.mantenimiento.config.JWTAuthorizationFilter;
import com.mantenimiento.config.JwtAuthenticationFilter;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

	private final UserDetailsService userDetailsService;
	private final JWTAuthorizationFilter jwtAutorizationFilter;
	
	@Bean
   SecurityFilterChain filterChain(HttpSecurity http,AuthenticationManager authManager) throws Exception {
	   
		JwtAuthenticationFilter jwtAuthentitacionFilter= new JwtAuthenticationFilter();
		jwtAuthentitacionFilter.setAuthenticationManager(authManager);
		jwtAuthentitacionFilter.setFilterProcessesUrl("/login");
		
		
		return http.csrf().disable()
			   .authorizeRequests()
			   .anyRequest()
			   .authenticated()
			   .and()
			   .httpBasic()
			   .and()
			   .sessionManagement()
			   .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			   .and()
			   .addFilter(jwtAuthentitacionFilter)
			   .addFilter(jwtAutorizationFilter)
			   .addFilterBefore(jwtAuthentitacionFilter, UsernamePasswordAuthenticationFilter.class)
			   .build();
   }
	
	/*@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .build());
        return manager;
    }
	
	@Bean
	AuthenticationManager authManager(HttpSecurity http) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder())
					.and()
					.build();
						
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		}

	
}*/
