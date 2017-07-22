package com.shigan.service.supermarketservice;

import com.shigan.pojo.supermarket.Order;

import java.util.List;

/**
 * Created by Administrator on 2017/7/19.
 */
public interface OrderService {
    //<!--插入订单表-->
    public int addorder(Order order);

    //<!--修改支付状态-->
    public int updateplaystatu(Order order);

    //<!--查询该用户下的订单信息-->
    public List<Order> getorderbyuserid(Integer userid);

    //<!--根据id查订单-->
    public Order getorderbyid(Integer id);

    //<!--根据id修改支付状态-->
    public int updateorderbyid(Integer id);
    //<!--根据id修配送状态与评论状态-->
    public int updateotherstatubyid(Order order);
}
