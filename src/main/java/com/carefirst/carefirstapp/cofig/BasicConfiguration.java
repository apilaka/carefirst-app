package com.carefirst.carefirstapp.cofig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

@Configuration
//@EnableWebSecurity
public class BasicConfiguration{
//http://localhost:8764/login
	//http://localhost:8764/logout
//
//    
    @Bean
    public UserDetailsService userDetailsService (){
    	
    
    	
    	UserDetails user = User.withUsername("user")
    			.password(passwordEncoder().encode("user"))
    			.roles("USER")
    			.build();
    	UserDetails admin = User.withUsername("admin")
    			.password(passwordEncoder().encode("admin"))
    			.roles("USER","ADMIN")
    			.build();
   	
    	 
		return new InMemoryUserDetailsManager(user,admin);
    	
    }

    @Bean
    @Primary
    HttpSecurity web(HttpSecurity http) throws Exception {
    	 
    	return http.csrf().disable()
        .authorizeHttpRequests((authorize) -> authorize
        		 // .anyRequest().permitAll()
        		 .requestMatchers("/login","/logout").permitAll()
        		
        		 .requestMatchers("/api/v3/admin/**").hasRole("ADMIN")
        		 .requestMatchers("/api/v3/user/**").hasRole("USER")
//            .requestMatchers(HttpMethod.GET).hasAuthority("USER")
//            .requestMatchers(HttpMethod.POST).hasAuthority("ADMIN")
//            .requestMatchers(HttpMethod.PUT).hasAuthority("ADMIN")
//            .requestMatchers(HttpMethod.DELETE).hasAuthority("ADMIN")
           
          
        );
   

  
    }
    
    
    
    
    
    
    
    
	@Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }
}