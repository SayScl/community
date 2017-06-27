package com.shigan.service.serviceImpl;

import com.shigan.mapper.UserMapper;
import com.shigan.pojo.User;
import com.shigan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public int modify(User user) {
        int row = userMapper.modify(user);
        return row;
    }
}
