package com.zl.service;

import com.zl.Mapper.UserMapper;
import com.zl.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService1 {

    @Autowired
    private UserMapper userMapper;

    public List<User> findUserList(){
        return userMapper.findUserList();
    }
}
