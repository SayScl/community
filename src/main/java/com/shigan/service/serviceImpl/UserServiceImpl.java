package com.shigan.service.serviceImpl;

import com.shigan.mapper.UserMapper;
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
    @Override
    @Transactional
    public int register() {
        int rows = userMapper.register();
        return rows;
    }
}
