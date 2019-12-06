package com.tcs.banking.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Description of file WebSecurityConfig.java
 * 
 * @author adem
 *
 *         It is used to set the web security configuration
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;


		// JDBC authentication
//		auth.jdbcAuthentication().dataSource(dataSource)
//				.usersByUsernameQuery(
//						"select username as principal, password as credentials, active from users where username=?")
//				.authoritiesByUsernameQuery(
//						"select username as principal, role as role from users_roles where username =?")
//				.rolePrefix("ROLE_").passwordEncoder(new Md5PasswordEncoder());



    @Override
    protected void configure(AuthenticationManagerBuilder managerBuilder) throws Exception{
        managerBuilder.inMemoryAuthentication()
                .withUser("ravi").password("{noop}1234").roles("USER").and()
                .withUser("admin").password("{noop}1234").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic().and().authorizeRequests()
                .antMatchers("/addItem","/delete").hasRole("ADMIN")
                .antMatchers("/getAllItems").access("hasRole('USER') or hasRole('ADMIN')")
                .antMatchers("/customer/**").access("hasRole('USER') or hasRole('ADMIN')")
                .and().csrf().disable().headers().frameOptions().disable();
    }

}
