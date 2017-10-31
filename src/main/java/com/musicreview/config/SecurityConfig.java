package com.musicreview.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity //включает веб секьюрити
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(getShaPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").hasAnyRole("USER", "ADMIN") // имеют доступ юзеры и админы
                .antMatchers("/admin").hasRole("ADMIN") // имеют доступ дмины
                .antMatchers("/register").permitAll() // имеют доступ все
                .and()
        .exceptionHandling().accessDeniedPage("/unauthorized") //сюда перекинет если лезет куда не нужно
                .and()
        .formLogin() //связываем с формой логина пароля
                .loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check") // экшн нашей функции логина и пароля
                .failureUrl("/login?error") // куда перекинуть если ввели неправ логин и пароль
                .usernameParameter("j_login")
                .passwordParameter("j_password") //название откуда берутся инпуты
                .permitAll() //пускать всех
                .and()
        .logout()
                .permitAll()
                .logoutUrl("/logout") // перенаправляет на /logout" чтобы выйти
                .logoutSuccessUrl("/login?logout") //сюда выкинет если вышли из учётки
                .invalidateHttpSession(true); //прибить сессию по выходу
    }

    private ShaPasswordEncoder getShaPasswordEncoder(){
        return new ShaPasswordEncoder();
    }
}
