package com.shigan.service.supermarketservice;

import com.shigan.pojo.supermarket.Category;
import org.apache.catalina.startup.Catalina;

import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */
public interface CategoryService {

    //查找分类
    public List<Category> getcategory();
}
