package com.lupuleasa.coffee.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/").hasAnyRole("ADMIN", "USER")
                .antMatchers("/menu").hasAnyRole("ADMIN", "USER")
                .antMatchers("/custom").hasAnyRole("ADMIN", "USER")
                .antMatchers("/addCustom").hasAnyRole("ADMIN", "USER")
                .antMatchers("/customSuccess").hasAnyRole("ADMIN", "USER")
                .antMatchers("/orders").hasAnyRole("ADMIN", "USER")
                .antMatchers("/orders/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/cart").hasAnyRole("ADMIN", "USER")
                .antMatchers("/admin/customers").hasAnyRole("ADMIN")
                .antMatchers("/admin/customers/**").hasAnyRole("ADMIN")
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/addCustomer").hasAnyRole("ADMIN")
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/checkout").hasAnyRole("ADMIN", "USER")
                .antMatchers("/checkout/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/create-payment-intent").hasAnyRole("ADMIN", "USER")
                .and().formLogin();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance(); }


    }


