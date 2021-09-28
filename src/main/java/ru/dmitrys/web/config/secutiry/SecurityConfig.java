package ru.dmitrys.web.config.secutiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.dmitrys.web.config.secutiry.handler.LoginSuccessHandler;
import ru.dmitrys.web.service.UserServiceImpl;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserServiceImpl userDetailsService;
    private final LoginSuccessHandler successHandler;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(UserServiceImpl userDetailsService, LoginSuccessHandler successHandler,
                          PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.successHandler = successHandler;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                //пароль здесь - admin
                .password("$2a$12$AuC2If5Gvs6rX1RY7GzzTuO3mEleZINyLTS8lH4705h0ffhWnn46O")
                .roles("ADMIN");

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .successHandler(successHandler)
                .permitAll();

        http.logout()
                .permitAll()
                .and().csrf().disable();

        http.authorizeRequests()
                .antMatchers("/login").anonymous()
                .antMatchers("/user").access("hasAnyRole('USER', 'ADMIN')")
                .antMatchers("/admin").access("hasRole('ADMIN')").anyRequest().authenticated();
    }
}
