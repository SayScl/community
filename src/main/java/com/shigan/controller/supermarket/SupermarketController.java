package com.shigan.controller.supermarket;

import com.shigan.pojo.User;
import com.shigan.pojo.supermarket.Category;
import com.shigan.pojo.supermarket.Product;
import com.shigan.pojo.supermarket.Shopcar;
import com.shigan.pojo.supermarket.Shopcaritems;
import com.shigan.service.supermarketservice.CategoryService;
import com.shigan.service.supermarketservice.ProductService;
import com.shigan.service.supermarketservice.ShopcarService;
import org.apache.catalina.startup.Catalina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/12.
 */
@Controller
@RequestMapping("market")
public class SupermarketController {
    @Autowired
    private ShopcarService shopcarService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    //跳转到社区超市页面

    @RequestMapping("tosupermarket")
    public String tosupermarket(Model model){
        List<Category> categorys = categoryService.getcategory();
        for(Category c:categorys){
            List<Product> products = productService.getproductinfoByCategoryid(c.getId());
            c.setProducts(products);
        }
        model.addAttribute("categorys",categorys);
        return "/market/supermarket";
    }
    //跳转到购物车页面（添加到购物车）
    @PostMapping("shopcaritems")
    @ResponseBody
    public Map shopcaritems(@RequestBody List<Shopcaritems> list, HttpServletRequest request){
        HttpSession session = request.getSession();
        //获得登录用户
        User user =(User) session.getAttribute("user");
        double totalprice=0;
        //从前台获得购物项详细信息
        for(int i=0;i<list.size();i++){
            Shopcaritems sp=new Shopcaritems();
            sp.setProductcount(list.get(i).getProductcount());
            //获得购物车总价格
            double producttotalprice=productService.getproductinfoById(list.get(i).getProductid()).getPrice()*list.get(i).getProductcount();
            totalprice=totalprice+producttotalprice;
            sp.setProducttotalprice(producttotalprice);
            sp.setProductid(list.get(i).getProductid());
            sp.setUserid(user.getId());
            shopcarService.addshopcaritems(sp);
        }
        //获得这个用户的购物项
        List<Shopcaritems> shopcaritems = shopcarService.getshopcaritemsbyuserid(user.getId());
        StringBuffer s=new StringBuffer();
        //将这个用户下的商品名字保存进去
        for(int k=0;k<shopcaritems.size();k++){
            Product product = productService.getproductinfoById(shopcaritems.get(k).getProductid());
            shopcaritems.get(k).setProductname(product.getProductname());
        }
        //获得购物项id集
        for(int j=0;j<shopcaritems.size();j++){
            s.append(shopcaritems.get(j).getId());
        }
        Shopcar sc=new Shopcar();
        sc.setItemsid(s.toString());
        sc.setUserid(user.getId());
        sc.setTotalprice(totalprice);
        //将这个用户的购物车信息保存到数据库
        int addshopcar = shopcarService.addshopcar(sc);
        Map map=new HashMap();
        map.put("shopcaritems",shopcaritems);
        return map;
    }
}
