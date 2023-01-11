package com.example.restexample.restexample.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.restexample.restexample.services.auth.AuthEntryPointJwt;
import com.example.restexample.restexample.services.auth.AuthTokenFilter;

@Configuration
public class ConfigurationService {

    private final UserDetailsService userDetailsService;
    private final AuthEntryPointJwt unauthorizedHandler;

    @Autowired
    public ConfigurationService(@Qualifier("securityService") UserDetailsService userDetailsService, AuthEntryPointJwt authEntryPointJwt){
        this.userDetailsService = userDetailsService;
        this.unauthorizedHandler = authEntryPointJwt;
    }

    @Bean
    public AuthTokenFilter authenticacionJwTokenFilter(){
        return new AuthTokenFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider aProvider = new DaoAuthenticationProvider();
        aProvider.setUserDetailsService(userDetailsService);
        aProvider.setPasswordEncoder(passwordEncoder());
        return aProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeRequests().antMatchers("/auth/login").permitAll()
        .anyRequest().authenticated();
        
        http.authenticationProvider(authenticationProvider());
        http.addFilterBefore(authenticacionJwTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
        
    }

}
