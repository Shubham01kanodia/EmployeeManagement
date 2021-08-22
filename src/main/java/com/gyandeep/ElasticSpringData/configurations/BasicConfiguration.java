package com.gyandeep.ElasticSpringData.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter{
	
	@Value("${adminUserPassword}")
	String adminUserPassword;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth
          .inMemoryAuthentication()
          .withUser("admin")
          .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(adminUserPassword))
          .roles("ADMIN");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    	http
        .authorizeRequests()
        .antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
        //.antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
        .and()
        .httpBasic();
    }
    @Override
    public void configure(WebSecurity web) throws Exception 
    {
    	web.ignoring().antMatchers(HttpMethod.POST);
    	web.ignoring().antMatchers(HttpMethod.GET);
 
    }
    
    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
    	return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
