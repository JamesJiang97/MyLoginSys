package com.jiang.controller;


import com.alibaba.fastjson.JSONObject;
import com.jiang.pojo.User;
import com.jiang.service.UserService;
import com.jiang.util.TokenUtil;
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
    public Object nameExist(@RequestBody User user, HttpServletRequest request , HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        boolean flag =  userService.nameExist(user.getName());
        if(flag){
            jsonObject.put("code",500);
        }
        else {
            jsonObject.put("code",200);
        }
        return jsonObject;
    }

    @PostMapping("/emailExist")
    public Boolean emailExist(@RequestBody User user){
        System.out.println(user.getEmail());
        return userService.emailExist(user.getEmail());
    }

    @PostMapping("/signIn")
    public Object signIn(@RequestBody User user, HttpServletRequest request , HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        User flag = userService.signIn(user.getEmail(), user.getPw(), request, response);
        if (flag != null){
            String token = TokenUtil.sign(flag);
            jsonObject.put("userId", flag.getId());
            jsonObject.put("userName", flag.getName());
            jsonObject.put("token",token);
            jsonObject.put("msg","success");
            jsonObject.put("code",200);
        }
        else {
            jsonObject.put("msg","failed");
            jsonObject.put("code",500);
        }
        return jsonObject;
    }

    @PostMapping("/signUp")
    public Boolean signUp(@RequestBody User user, HttpServletRequest request , HttpServletResponse response){
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        System.out.println(user.getPw());
        return  userService.signUp(user.getName(), user.getEmail(), user.getPw());
    }
}