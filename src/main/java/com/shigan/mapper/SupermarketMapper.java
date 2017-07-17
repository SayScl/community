package com.shigan.mapper;

import com.shigan.pojo.supermarket.Category;
import com.shigan.pojo.supermarket.Product;
import com.shigan.pojo.supermarket.Shopcar;
import com.shigan.pojo.supermarket.Shopcaritems;
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


    //<!--增加到购物项-->
    public int addshopcaritems(Shopcaritems shopcaritems);

    //<!--根据用户查购物项-->
    public List<Shopcaritems> getshopcaritemsbyuserid(Integer userid);

   // <!--增加购物车-->
    public int addshopcar(Shopcar shopcar);

}
