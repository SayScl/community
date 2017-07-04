package com.shigan.service;

import com.shigan.pojo.Ad;
import com.shigan.pojo.CityCommunity;
import com.shigan.pojo.Limit;
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


    //查找是否存在手机号
    public User getPhoneNumber(User user);

    //修改一个用户密码
    public int modify(User user);


    //查找广告
    public List<Ad> getAdByAdId(Ad ad);


    //查找所有城市名
    public List<CityCommunity> getCtiys();

    //根据城市id找小区
    public List<CityCommunity> getCommunityByCityId(CityCommunity cityCommunity);

    //查找所有小区
    public List<CityCommunity> getCommunity();


     //查询所有功能
    public List<Limit> getLimits();
}
