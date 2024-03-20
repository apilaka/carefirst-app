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
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
//        UserDetails user = User.withUsername("user")
//            .password(passwordEncoder.encode("user"))
//            .roles("USER")
//            .build();
//
//        UserDetails admin = User.withUsername("admin")
//            .password(passwordEncoder.encode("admin"))
//            .roles("USER", "ADMIN")
//            .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }
    
 //   @Bean
//    public void configure(AuthenticationManagerBuilder auth) throws Exception{
//    	
//    	auth.inMemoryAuthentication()
//    	.withUser("user")
//    	.password(passwordEncoder().encode("userpassword"))
//    	.roles("USER");
//    	
//    	auth.inMemoryAuthentication()
//    	.withUser("admin")
//    	.password(passwordEncoder().encode("adminpassword"))
//    	.roles("USER");
//    	
//    	
//    }
//    
    
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
    
//    
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
    		
    		
    		
    	
    	
    	
    	
//        return http.authorizeHttpRequests(request -> request.anyRequest()
//                .authenticated())
//            .httpBasic(Customizer.withDefaults())
//            .build();
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    	http
//        .authorizeHttpRequests((authorize) -> authorize
//        		  .requestMatchers("http://localhost:8764/login", "/http://localhost:8764/logout").permitAll()
// 
//          
//            
//        );
//	return http.build();
//   }
    
  
//    @Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http
//			.securityMatcher("/api/v3/listEmployees")                            
//			.authorizeHttpRequests(authorize -> authorize
//			//	.requestMatchers("/listEmployees").hasRole("USER")       
//				.requestMatchers("/api/v3/**").hasRole("ADMIN")     
//				.anyRequest().authenticated()                      
//			);
//		return http.build();
//	}

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }
}