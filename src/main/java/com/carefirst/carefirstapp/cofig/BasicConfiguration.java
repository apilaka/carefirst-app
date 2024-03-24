package com.carefirst.carefirstapp.cofig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
//       
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    	
//    	  return http
//                  .csrf(CsrfConfigurer::disable)
//                  .authorizeHttpRequests(requests -> requests
//                          .requestMatchers("/login").permitAll()
//                          .requestMatchers("/api/v3/user/**").hasRole("USER")
//                          .requestMatchers("/api/v3/admin/**","/api/v3/user/**").hasRole("ADMIN")
//                  )
//                  .formLogin(Customizer.withDefaults())
//                  .build();
//
//    			
//
//    }


//
	@Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }
}