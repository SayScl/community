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

    //<!--根据id查购物项-->
    public List<Shopcaritems> getshopcaritemsbyid(List list);


    //<!--根据商品id查找购物项-->
    public Shopcaritems getshopcaritemsbyproductid(Integer productid);

    //<!--根据用户id删除购物车-->
    public int deleteshopcarbyuserid(Integer userid);

    //<!--根据用户id查购物项数量-->
    public int getcountshopcaritems(Integer userid);

    //<!--修改购物项商品名字-->
    public int updateshopcaritemsproductnamebyproductid(Shopcaritems shopcaritems);

    // <!--增加购物车-->
    public int addshopcar(Shopcar shopcar);

    //<!--根据用户id删除购物项-->
    public int deleteshopcaritemsbyuserid(Integer userid);


    //<!--根据商品Id删除购物项-->
    public int deleteshopcaritemsbyproductid(Integer productid);

    //<!--根据商品id修改购物项-->
    public int updatebyproductid(Shopcaritems shopcaritems);

    //<!--根据用户id修改用户购物车信息-->
    public int updateshopcarbyuserid(Shopcar shopcar);

    //<!--查询该用户的购物车信息-->
    public Shopcar getshopcarbyuserid(Shopcar shopcar);
}
