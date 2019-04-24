package pl.dmcs.mww.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN","USER");
		auth.inMemoryAuthentication().withUser("kapj").password("{noop}kapj").roles("USER");
		auth.inMemoryAuthentication().withUser("student").password("{noop}student").roles("STUDENT");

		//User.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/appUsers*").access("hasRole('ADMIN')")
				// "hasRole('ADMIN')" is the same as "hasRole('ROLE_ADMIN')" and "hasAuthority('ROLE_ADMIN')"
				.antMatchers("/exampleOne*").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
				.antMatchers("/exampleTwo*").access("hasRole('ROLE_STUDENT')")
				.antMatchers("/exampleThree*").access("hasRole('ROLE_USER')")
				//.and().formLogin().permitAll(); // with default login page
				.and().formLogin().loginPage("/login").permitAll() // with custom login page
				.usernameParameter("login").passwordParameter("password")
				.failureForwardUrl("/login.html?error")
				.and().logout().logoutSuccessUrl("/login.html?logout")
				.and().exceptionHandling().accessDeniedPage("/accessDenied");
	}
}


