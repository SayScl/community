package com.shigan.service.supermarketservice;

import com.shigan.pojo.supermarket.Product;
import org.apache.catalina.startup.Catalina;

import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */
public interface ProductService {


    //<!--根据分类id查找商品详细信息-->
    public List<Product> getproductinfoByCategoryid(Integer id);

    //<!--根据id查找商品信息-->
    public Product getproductinfoById(Integer productid);

    //<!--根据名字和价格查商品信息-->
    public Product getproductbynameprice(Product product);

    //<!--修改信息-->
    public int updateproductbynameprice(Product product);
}
