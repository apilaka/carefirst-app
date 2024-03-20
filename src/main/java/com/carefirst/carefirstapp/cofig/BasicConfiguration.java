package com.carefirst.carefirstapp.cofig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class BasicConfiguration{
//http://localhost:8764/login
	//http://localhost:8764/logout

    
    @Bean
    public UserDetailsService userDetailsService (){
    	
    	UserDetails user = User.withUsername("user")
    			.password(passwordEncoder().encode("user"))
    			.build();
    	UserDetails admin = User.withUsername("admin")
    			.password(passwordEncoder().encode("admin"))
    			.build();
   	
    	
		return new InMemoryUserDetailsManager(user,admin);
    	
    }
       
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	
    	return http.csrf().disable()
    		.authorizeHttpRequests()
    		.requestMatchers("/api/v3/user/**").permitAll()
    		.and()
    		.authorizeHttpRequests().requestMatchers("/api/v3/admin/**").authenticated()
    		.and().formLogin()
    		.and()
    		.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }
}