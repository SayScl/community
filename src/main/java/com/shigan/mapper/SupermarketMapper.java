package com.shigan.mapper;

import com.shigan.pojo.supermarket.*;
import org.apache.catalina.startup.Catalina;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */
@Component
@Mapper
public interface SupermarketMapper {

    //查找分类
    public List<Category> getcategory();


    //<!--根据分类id查找商品详细信息-->
    public List<Product> getproductinfoByCategoryid(Integer id);

    //<!--根据id查找商品信息-->
    public Product getproductinfoById(Integer productid);


    //<!--根据名字和价格查商品信息-->
    public Product getproductbynameprice(Product product);

    //<!--修改信息-->
    public int updateproductbynameprice(Product product);


    //<!--增加到购物项-->
    public int addshopcaritems(Shopcaritems shopcaritems);

    //<!--根据用户查购物项-->
    public List<Shopcaritems> getshopcaritemsbyuserid(Integer userid);

    //<!--根据用户id查购物项数量-->
    public int getcountshopcaritems(Integer userid);


    //<!--根据用户id删除购物项-->
    public int deleteshopcaritemsbyuserid(Integer userid);

    //<!--根据商品Id删除购物项-->
    public int deleteshopcaritemsbyproductid(Integer productid);

    //<!--根据id查购物项-->
    public List<Shopcaritems> getshopcaritemsbyid(List list);


    //<!--根据商品id查找购物项-->
    public Shopcaritems getshopcaritemsbyproductid(Integer productid);

   // <!--增加购物车-->
    public int addshopcar(Shopcar shopcar);

    //<!--根据用户id删除购物项-->
    public int deleteshopcarbyuserid(Integer userid);

    //<!--根据商品id修改购物项-->
    public int updatebyproductid(Shopcaritems shopcaritems);

    //<!--根据用户id修改用户购物车信息-->
     public int updateshopcarbyuserid(Shopcar shopcar);


     //<!--查询该用户的购物车信息-->
    public Shopcar getshopcarbyuserid(Shopcar shopcar);

    //<!--修改购物项商品名字-->
    public int updateshopcaritemsproductnamebyproductid(Shopcaritems shopcaritems);


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

    //<!--插入评价表-->
    public int adddisscuss(Disscuss disscuss);

    //<!--查看当前模块的评论-->
    public List<Disscuss> getmarketdiscuss(Integer id);



}
