package com.shigan.service.serviceImpl.supermarketServiceImpl;

import com.shigan.mapper.SupermarketMapper;
import com.shigan.pojo.supermarket.Shopcar;
import com.shigan.pojo.supermarket.Shopcaritems;
import com.shigan.service.supermarketservice.ShopcarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */
@Service
public class ShopcarServiceImpl implements ShopcarService {
    @Autowired
    private SupermarketMapper supermarketMapper;
    //增加购物项
    @Override
    public int addshopcaritems(Shopcaritems shopcaritems) {
        int i = supermarketMapper.addshopcaritems(shopcaritems);
        return i;
    }

    //根据用户id查购物项
    @Override
    public List<Shopcaritems> getshopcaritemsbyuserid(Integer userid) {
        List<Shopcaritems> list = supermarketMapper.getshopcaritemsbyuserid(userid);
        return list;
    }

    //增加到购物车中
    @Override
    public int addshopcar(Shopcar shopcar) {
        int i = supermarketMapper.addshopcar(shopcar);
        return i;
    }
}
