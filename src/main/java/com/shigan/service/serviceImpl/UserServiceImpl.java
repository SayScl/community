package com.shigan.service.serviceImpl;

import com.shigan.mapper.UserMapper;
import com.shigan.pojo.Ad;
import com.shigan.pojo.CityCommunity;
import com.shigan.pojo.Limit;
import com.shigan.pojo.User;
import com.shigan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    //注册添加一个用户
    @Override
    @Transactional
    public int register(User user) {
        int rows = userMapper.register(user);
        return rows;
    }

    //登录查询一个用户
    @Override
    public User getOne( User user) {
        User u1 = userMapper.getOne(user);
        return u1;
    }

    //查找手机号是否存在
    @Override
    public User getPhoneNumber(User user) {
        User phoneNumber = userMapper.getPhoneNumber(user);
        return phoneNumber;
    }

    @Override
    @Transactional
    public int modify(User user) {
        int row = userMapper.modify(user);
        return row;
    }

    //查找广告
    @Override
    public List<Ad> getAdByAdId(Ad ad) {
        List<Ad> ads = userMapper.getAdByAdId(ad);
        return ads;
    }

    //查找所有城市名
    @Override
    public List<CityCommunity> getCtiys() {
        List<CityCommunity> ctiys = userMapper.getCtiys();
        return ctiys;
    }

    //根据cityid找小区
    @Override
    public List<CityCommunity> getCommunityByCityId(CityCommunity cityCommunity) {
        List<CityCommunity> communityByCityId = userMapper.getCommunityByCityId(cityCommunity);
        return communityByCityId;
    }

    @Override
    public List<CityCommunity> getCommunity() {
        List<CityCommunity> community = userMapper.getCommunity();
        return community;
    }

    //查询功能列表
    @Override
    public List<Limit> getLimits() {
        List<Limit> limits = userMapper.getLimits();
        return limits;
    }
}
