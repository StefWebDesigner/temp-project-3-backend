package com.revature.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.*;

@Configuration
@EnableWebSecurity
public class HttpConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //Disabling CSRF as not using form based login
        http.csrf().disable();

        //The urls that do not require authorization
        http.authorizeRequests().antMatchers(
                "/h2",
                "/register"
        ).permitAll();

        http.headers().frameOptions().disable();
    }

}
