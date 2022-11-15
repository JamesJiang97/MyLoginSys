package com.jiang.service.impl;

import com.jiang.dao.UserDao;
import com.jiang.pojo.User;
import com.jiang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public Boolean nameExist(String username) {
        return userDao.getByName(username) != null;
    }

    @Override
    public Boolean emailExist(String email) {
        return userDao.getByEmail(email) != null;
    }


    @Override
    public User signIn(String email, String pw, HttpServletRequest request , HttpServletResponse response) {
        return userDao.loginByEmail(email, pw);
    }

    @Override
    public Boolean signUp(String name, String email, String pw) {
        LocalDateTime Date = LocalDateTime.now();
        DateTimeFormatter FormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String subDate = Date.format(FormatObj);
        return userDao.insert(name, email, pw, subDate) > 0;
    }

}

