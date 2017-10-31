package com.musicreview.service;

import com.musicreview.model.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
/*
* UserDetailsService спринговый интерфейс
* */
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired //сюда инжектим наш сервис
    private UserService userService;

    /*
    * каждый раз когда вводится логин пароль и спринг секьюрити перехватывает его и
    * */
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        CustomUser customUser = userService.getUserByLogin(login);// дай мне юзера по логину
        if (customUser == null)
            //если нет такого юзера выведет ексепшин и вы ввели неправильн пароль
            throw new UsernameNotFoundException(login + " not found");

        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(customUser.getRole().toString()));
     //если правильн то возвращаем
        return new User(customUser.getLogin(), customUser.getPassword(), roles);
    }
}