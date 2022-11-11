package com.jiang.controller;


import com.jiang.pojo.User;
import com.jiang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/nameExist")
    public Boolean nameExist(@RequestBody User user, HttpServletRequest request , HttpServletResponse response){
        System.out.println(user.getName());
        System.out.println("userExist running");
        return userService.nameExist(user.getName());
    }

    @PostMapping("/emailExist")
    public Boolean emailExist(@RequestBody User user){
        System.out.println(user.getEmail());
        return userService.emailExist(user.getEmail());
    }


    @PostMapping("/signIn")
    public Boolean signIn(@RequestBody User user, HttpServletRequest request , HttpServletResponse response){
        return userService.signIn(user.getEmail(), user.getPw(), request, response);
    }

    @PostMapping("/signUp")
    public Boolean signUp(@RequestBody User user){
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        System.out.println(user.getPw());
        return  userService.signUp(user.getName(), user.getEmail(), user.getPw());
    }
}