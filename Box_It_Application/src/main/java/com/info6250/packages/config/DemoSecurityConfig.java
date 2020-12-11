package com.info6250.packages.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.info6250.packages.service.UserService;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;



@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	
	// Add a reference to our security data source
	

	@Autowired
	private UserService userService;
    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    
   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticateProvider());
    }

   
   /*	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Use JDBC authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
		
		
		
		UserBuilder users = User.withDefaultPasswordEncoder();		

		auth.inMemoryAuthentication()
		.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
		.withUser(users.username("mary").password("test123").roles("EMPLOYEE", "ADMIN"))
		.withUser(users.username("susan").password("test123").roles("EMPLOYEE", "MANAGER"))
		.withUser(users.username("chef1").password("test123").roles("EMPLOYEE", "CHEF"))
		.withUser(users.username("del1").password("test123").roles("EMPLOYEE", "DELIVERY_EXECUTIVES"))
		.withUser(users.username("del1").password("test123").roles("EMPLOYEE", "CUSTOMER"));
		
	}
*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		
        http.authorizeRequests()
	//        .antMatchers("/customerLogin").permitAll()  // allow public access to home page
	        .antMatchers("/register").permitAll()
	        .antMatchers("/home").hasAnyRole("CUSTOMER", "EMPLOYEE", "MANAGER", "ADMIN", "DELIVERY_EXECUTIVES", "CHEF")
	        .antMatchers("/myworkspace").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN", "DELIVERY_EXECUTIVES", "CHEF")
	        .antMatchers("/myworkspace/**").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN", "DELIVERY_EXECUTIVES", "CHEF") 
	        .antMatchers("/my-box-it").hasRole("CUSTOMER")
	        .antMatchers("/my-box-it/**").hasRole("CUSTOMER")
	        .antMatchers("/employees").hasRole("EMPLOYEE")
	        .antMatchers("/myworkspace/managers/**").hasRole("MANAGER")
	        .antMatchers("/systems/**").hasRole("ADMIN")
	        .antMatchers("/deliveryExecWorkspace/**").hasRole("DELIVERY_EXECUTIVES")
	        .antMatchers("/chefWorkspace/**").hasRole("CHEF")
	        .and()
	        .formLogin()
		        .loginPage("/BoxItLoginPage")
		        .loginProcessingUrl("/authenticateTheUser")
		        .successHandler(customAuthenticationSuccessHandler)
		        .permitAll()
		        .and()
		        .logout().permitAll()
		        .logoutSuccessUrl("/")  // after logout then redirect to landing page (root)
		        .permitAll()
		        .and()
		        .exceptionHandling().accessDeniedPage("/access-denied");
		   
        
		
//		http.authorizeRequests()
//		.anyRequest().authenticated()
//		.and()
//		.formLogin()
//		.loginPage("/BoxItLoginPage") // Kuch bhi ho sakta hai. 
//		.loginProcessingUrl("/authenticateTheUser") // Yaha par bhi. BC neend aa rahi hai...
//		.permitAll()
//		.and()
//		.logout().permitAll();
		
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	public DaoAuthenticationProvider authenticateProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
		
		
	}

}
