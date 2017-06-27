package com.shigan.mapper;

import com.shigan.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/6/26.
 */
@Component
@Mapper
public interface UserMapper {

    //注册一个用户
    public int register(User user);

    //登录查询用户
    public User getOne(User user);
}
