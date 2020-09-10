package com.zl.service;

import com.zl.pojo.User;

import java.awt.*;

public interface UserService {

    default List findUserList() {
        return null;
    }
}
