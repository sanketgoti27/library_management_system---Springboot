package com.example.security.config;

import com.example.security.filter.JwtAuthFilter;
import com.example.security.service.implService.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private JwtAuthFilter authFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/books/**", "/api/patrons/**", "/api/borrowingRecords/**", "/auth/login")
                .permitAll()
                .anyRequest().authenticated().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Add a filter to validate the tokens with every request
        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);

//        http
//                .exceptionHandling()
//                .accessDeniedHandler(accessDeniedHandler())
//                .and()
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/users/**","/api/books/**","/api/patrons/**","/api/borrowingRecords/**","/auth/login").permitAll()
//                .anyRequest().authenticated()
//                .and()
////                .and()
////                .formLogin()
////                .loginPage("/auth/login")
////                .loginProcessingUrl("/doLogin")
////                .defaultSuccessUrl("/users/")
////                .permitAll()
////                .and()
////                .logout()
////                .logoutUrl("/signout")
////                .logoutSuccessUrl("/signin")
////                .permitAll()
////                .and()
////                .sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                .and()
////                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                        .and()
//                        .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class));
    }

    private AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
