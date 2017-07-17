package com.shigan.service.serviceImpl.supermarketServiceImpl;

import com.shigan.mapper.SupermarketMapper;
import com.shigan.pojo.supermarket.Category;
import com.shigan.service.supermarketservice.CategoryService;
import org.apache.catalina.startup.Catalina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private SupermarketMapper supermarketMapper;
    //查找所有分类
    @Override
    public List<Category> getcategory() {
        List<Category> categorys = supermarketMapper.getcategory();
        return categorys;
    }
}
