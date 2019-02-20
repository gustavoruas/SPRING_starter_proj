package oracle.starterSPRING.hr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import oracle.starterSPRING.config.AuthenticationEntryPoint;
import oracle.starterSPRING.hr.services.UserService;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userServs;
	
	
	public AuthenticationEntryPoint entryPoint;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{		
		auth.userDetailsService(userServs);
	}
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated();
		//.and().httpBasic().authenticationEntryPoint(entryPoint);
		
	}

	
	/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		  .authorizeRequests()
		  .antMatchers("/","/department","/location","/list").permitAll()
		  .anyRequest().authenticated()
		.and()
		  .logout()
		  .permitAll()
		  ;
	}
	*/
	
	
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		@SuppressWarnings("deprecation")
//		UserDetails user = User.withDefaultPasswordEncoder()
//				.username("admin")
//				.password("admin")
//				.roles("USER")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user);
//		
//	}	
	
}
