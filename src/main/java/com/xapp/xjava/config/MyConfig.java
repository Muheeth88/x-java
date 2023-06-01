package com.xapp.xjava.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter {
    
    // @Bean
    // public UserDetailsService getUserDetailsService() {
    //     return new UserDetailsServiceImpl();
    // }

    // @Bean
    // public DaoAuthenticationProvider authenticationProvider() {

    //     DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    //     daoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
        
    //     return daoAuthenticationProvider;
    // }

    // // Configure Method

    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     auth.authenticationProvider(authenticationProvider());
    // }

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http.authorizeHttpRequests().antMatchers("/**").permitAll();
    // }

    // -----------------------------------------------------------------------------------------------------------
    
    @Autowired
    private UserDetailsService userDetailsService;

    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        // provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/users").hasAuthority("USER")
                .antMatchers("/admin").hasAuthority("ADMIN");
                // .anyRequest()
                // .authenticated();
                // .and().
                // httpBasic(withDefaults());
    }

}
