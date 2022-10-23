package com.jiang.service;


public interface UserService {

    Boolean userExist(String user);
    Boolean signIn(String user, String pw);
    Boolean signUp(String name, String email, String pw);

}
