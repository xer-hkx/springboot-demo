package com.resource.share.controller;


import com.resource.share.entity.User;
import com.resource.share.service.UserService;
import com.resource.share.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    private Result<User> login(@RequestBody User user){
        Result<User> result = new Result<>();
        user = userService.queryUser(user);
        if(user == null){
            result.setMsg("用户名或密码错误！");
            result.setCode(300);
        }else{
            result.setMsg("success");
            result.setCode(200);
        }
        result.setData(user);
        return result;
    }

    @RequestMapping("/admin")
    private Result<User> admin(){
        Result<User> result = new Result<>();
        User user = userService.queryUserByIsAdmin(1);
        result.setMsg("管理员账号");
        result.setData(user);
        return result;
    }

    @RequestMapping("/getbytoken")
    private Result<User> getByToken(String token){
        Result<User> result = new Result<>();
       User user = userService.queryUserByToken(token);
       result.setData(user);
        return result;
    }
    @PostMapping("/adduser")
    private  Result<User> addUser(@RequestBody User user){
        Result<User> result = new Result<>();
        result.setMsg("success");
        user.setToken(UUID.randomUUID().toString());
        userService.insertUser(user);
        result.setData(user);
        return result;
    }

    @RequestMapping("/deleteuser")
    private Result deleteUser(Integer userId){
        Result result = new Result();
        result.setMsg("success");
        userService.deleteUser(userId);
        return result;
    }
}
