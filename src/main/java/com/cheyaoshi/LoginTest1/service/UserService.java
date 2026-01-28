package com.cheyaoshi.LoginTest1.service;

import com.cheyaoshi.LoginTest1.pojo.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User userLogin(User user);
    User userRegister(User user);
}
