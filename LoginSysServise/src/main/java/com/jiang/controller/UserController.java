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
    public Object emailExist(@RequestBody User user){
        JSONObject jsonObject = new JSONObject();
        boolean flag =  userService.emailExist(user.getEmail());
        if(flag){
            jsonObject.put("code",500);
        }
        else {
            jsonObject.put("code",200);
        }
        return jsonObject;
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
    public Object signUp(@RequestBody User user){
        JSONObject jsonObject = new JSONObject();
        boolean flag = userService.signUp(user.getName(), user.getEmail(), user.getPw());
        if (flag){
            jsonObject.put("msg","success");
            jsonObject.put("code",200);
        }
        else {
            jsonObject.put("msg","failed");
            jsonObject.put("code",500);
        }
        return jsonObject;
    }

    @PostMapping("/verifyToken")
    public Object verifyToken(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg","success");
        jsonObject.put("code",200);
        return jsonObject;
    }
}