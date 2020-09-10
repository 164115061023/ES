package com.zl.controller;

import com.zl.pojo.User;
import com.zl.service.UserService;
import com.zl.service.UserService1;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService1 userService;

    @GetMapping(value = "/userList")
    public List<User> findUserList(String callback){
        return userService.findUserList();
    }

    @PostMapping(value = "/add")
    public User addUser(@RequestBody User user, HttpServletResponse response){
        //response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        System.out.println(user.toString());
        System.out.println(11111);
        return user;
    }

}
