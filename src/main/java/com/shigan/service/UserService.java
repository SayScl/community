package com.shigan.service;

import com.shigan.pojo.User;

/**
 * Created by Administrator on 2017/6/26.
 */
public interface UserService {
    //注册一个用户
    public int register(User user);

    //登录查询用户
    public User getOne(User user);
}
