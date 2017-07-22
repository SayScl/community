package com.shigan.service.supermarketservice;

import com.shigan.pojo.supermarket.Disscuss;

import java.util.List;

/**
 * Created by Administrator on 2017/7/22.
 */
public interface DisscussService {
    //<!--插入评价表-->
    public int adddisscuss(Disscuss disscuss);
    //<!--查看当前模块的评论-->
    public List<Disscuss> getmarketdiscuss(Integer id);
}
