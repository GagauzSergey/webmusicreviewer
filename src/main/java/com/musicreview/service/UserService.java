package com.musicreview.service;

import com.musicreview.model.CustomUser;
import org.springframework.stereotype.Service;

public interface UserService {
    CustomUser getUserByLogin(String login);
    boolean existsByLogin(String login);
    void addUser(CustomUser customUser);
    void updateUser(CustomUser customUser);
}
