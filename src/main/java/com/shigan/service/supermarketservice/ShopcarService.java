package com.shigan.service.supermarketservice;

import com.shigan.pojo.supermarket.Shopcar;
import com.shigan.pojo.supermarket.Shopcaritems;

import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */
public interface ShopcarService {

    //<!--增加到购物项-->
    public int addshopcaritems(Shopcaritems shopcaritems);

    //<!--根据用户查购物项-->
    public List<Shopcaritems> getshopcaritemsbyuserid(Integer userid);

    // <!--增加购物车-->
    public int addshopcar(Shopcar shopcar);
}
