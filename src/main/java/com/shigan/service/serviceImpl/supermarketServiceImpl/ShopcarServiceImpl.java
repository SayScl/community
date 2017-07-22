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

    //<!--根据id查购物项-->
    @Override
    public List<Shopcaritems> getshopcaritemsbyid(List list) {
        List<Shopcaritems> l = supermarketMapper.getshopcaritemsbyid(list);
        return l;
    }

    //<!--根据商品id查找购物项-->
    @Override
    public Shopcaritems getshopcaritemsbyproductid(Integer productid) {
        Shopcaritems getshopcaritemsbyproductid = supermarketMapper.getshopcaritemsbyproductid(productid);
        return getshopcaritemsbyproductid;
    }

    @Override
    public int deleteshopcarbyuserid(Integer userid) {
        int i = supermarketMapper.deleteshopcarbyuserid(userid);
        return i;
    }

    //根据用户id查购物项数量
    @Override
    public int getcountshopcaritems(Integer userid) {
        int i = supermarketMapper.getcountshopcaritems(userid);
        return i;
    }

    //根据商品id修改商品名
    @Override
    public int updateshopcaritemsproductnamebyproductid(Shopcaritems shopcaritems) {
        int i = supermarketMapper.updateshopcaritemsproductnamebyproductid(shopcaritems);
        return i;
    }

    //增加到购物车中
    @Override
    public int addshopcar(Shopcar shopcar) {
        int i = supermarketMapper.addshopcar(shopcar);
        return i;
    }

    @Override
    public int deleteshopcaritemsbyuserid(Integer userid) {
        int i = supermarketMapper.deleteshopcaritemsbyuserid(userid);
        return i;
    }

    //根据商品id删除购物项
    @Override
    public int deleteshopcaritemsbyproductid(Integer productid) {
        int i = supermarketMapper.deleteshopcaritemsbyproductid(productid);
        return i;
    }

    //根据商品ID修改购物项信息
    @Override
    public int updatebyproductid(Shopcaritems shopcaritems) {
        int updatebyproductid = supermarketMapper.updatebyproductid(shopcaritems);
        return updatebyproductid;
    }

    //根据用户id修改该用户购物车信息
    @Override
    public int updateshopcarbyuserid(Shopcar shopcar) {
        int updateshopcarbyuserid = supermarketMapper.updateshopcarbyuserid(shopcar);
        return updateshopcarbyuserid;
    }

    //查找该用户购物车信息
    @Override
    public Shopcar getshopcarbyuserid(Shopcar shopcar) {
        Shopcar getshopcarbyuserid = supermarketMapper.getshopcarbyuserid(shopcar);
        return getshopcarbyuserid;
    }
}
