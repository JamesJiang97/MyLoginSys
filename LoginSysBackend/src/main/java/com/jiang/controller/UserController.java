package com.jiang.controller;


import com.jiang.pojo.User;
import com.jiang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = {"http://127.0.0.1:5173"})

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping

    public Boolean userExist(@RequestBody User user){
        System.out.println(user.getName());
        System.out.println("userExist running");
        return userService.userExist(user.getName());
    }

    @PostMapping("/signIn")
    public Boolean signIn(@RequestParam String user,@RequestParam String pw){
        return userService.signIn(user, pw);
    }

    @PostMapping("/signUp")
    public Boolean signUp(@RequestBody User user){
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        System.out.println(user.getPw());
        return  userService.signUp(user.getName(), user.getEmail(), user.getPw());
    }
}