package com.jiang.service.impl;

import com.jiang.dao.UserDao;
import com.jiang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public Boolean userExist(String user) {
        if (user.contains("@")) {
            return userDao.getByEmail(user) != null;
        }else {
            return userDao.getByName(user) != null;
        }
    }


    @Override
    public Boolean signIn(String user, String pw) {
        if (user.contains("@")) {
            return userDao.loginByEmail(user, pw) != null;
        }else {
            return userDao.loginByName(user,pw) != null;
        }
    }

    @Override
    public Boolean signUp(String name, String email, String pw) {
        LocalDateTime Date = LocalDateTime.now();
        DateTimeFormatter FormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String subDate = Date.format(FormatObj);
        return userDao.insert(name, email, pw, subDate) > 0;
    }

}

