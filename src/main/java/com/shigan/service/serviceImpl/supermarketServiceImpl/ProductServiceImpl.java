package com.shigan.service.serviceImpl.supermarketServiceImpl;

import com.shigan.mapper.SupermarketMapper;
import com.shigan.pojo.supermarket.Product;
import com.shigan.service.supermarketservice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private SupermarketMapper supermarketMapper;
    //根据分类ID查找商品详细信息
    @Override
    public List<Product> getproductinfoByCategoryid(Integer id) {
        List<Product> products = supermarketMapper.getproductinfoByCategoryid(id);
        return products;
    }

    @Override
    public Product getproductinfoById(Integer productid) {

        Product products = supermarketMapper.getproductinfoById(productid);
        return products;
    }
}
