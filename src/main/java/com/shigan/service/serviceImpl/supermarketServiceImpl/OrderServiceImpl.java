package com.shigan.service.serviceImpl.supermarketServiceImpl;

import com.shigan.mapper.SupermarketMapper;
import com.shigan.pojo.supermarket.Order;
import com.shigan.service.supermarketservice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/7/19.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private SupermarketMapper supermarketMapper;
    //<!--插入订单表-->
    @Override
    @Transactional
    public int addorder(Order order) {
        int i = supermarketMapper.addorder(order);
        return i;
    }
    //<!--修改支付状态-->
    @Override
    public int updateplaystatu(Order order) {
        int i = supermarketMapper.updateplaystatu(order);
        return i;
    }

    //根据用户id查找该用户订单
    @Override
    public List<Order> getorderbyuserid(Integer userid) {
        List<Order> getorderbyuserid = supermarketMapper.getorderbyuserid(userid);
        return getorderbyuserid;
    }

    @Override
    public Order getorderbyid(Integer id) {
        Order getorderbyid = supermarketMapper.getorderbyid(id);
        return getorderbyid;
    }

    @Override
    public int updateorderbyid(Integer id) {
        int i = supermarketMapper.updateorderbyid(id);
        return i;
    }

    //<!--根据id修配送状态与评论状态-->
    @Override
    public int updateotherstatubyid(Order order) {
        int i = supermarketMapper.updateotherstatubyid(order);
        return i;
    }
}
