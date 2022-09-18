package com.example.shardingdatabasedemo.com.repository;

import com.example.shardingdatabasedemo.com.entity.User;

import java.util.List;

public interface UserDao extends BaseDao<User,String>{

    List<User> findByBizId(String bizId);
}
