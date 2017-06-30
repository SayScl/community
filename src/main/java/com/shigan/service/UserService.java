package com.shigan.service;

import com.shigan.pojo.Ad;
import com.shigan.pojo.User;

import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */
public interface UserService {
    //注册一个用户
    public int register(User user);

    //登录查询用户
    public User getOne(User user);

    //修改一个用户密码
    public int modify(User user);


    //查找广告
    public List<Ad> getAdByAdId(Ad ad);
}
