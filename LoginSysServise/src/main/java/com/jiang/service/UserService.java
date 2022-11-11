package com.jiang.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {

    Boolean nameExist(String user);
    Boolean emailExist(String email);
    Boolean signIn(String email, String pw, HttpServletRequest request , HttpServletResponse response);
    Boolean signUp(String name, String email, String pw);

}
