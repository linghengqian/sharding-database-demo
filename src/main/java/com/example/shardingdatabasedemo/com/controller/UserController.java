package com.example.shardingdatabasedemo.com.controller;

import com.example.shardingdatabasedemo.com.entity.User;
import com.example.shardingdatabasedemo.com.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/find")
    public List<User> find() {
        return userDao.findByBizId("123");
    }
}
