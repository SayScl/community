package com.shigan.controller.supermarket;

import com.shigan.pojo.Limit;
import com.shigan.pojo.User;
import com.shigan.pojo.supermarket.*;
import com.shigan.service.QiniuUploadService;
import com.shigan.service.UserService;
import com.shigan.service.supermarketservice.*;
import org.apache.catalina.startup.Catalina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/7/12.
 */
@Controller
@RequestMapping("market")
public class SupermarketController {

    @Autowired
    private QiniuUploadService qiniuUploadService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private ShopcarService shopcarService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private DisscussService disscussService;
    //跳转到社区超市页面

    @RequestMapping("tosupermarket")
    public String tosupermarket(Model model,HttpServletRequest request){

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Disscuss> disscusses = disscussService.getmarketdiscuss(user.getCommunityid());
        //获得所有分类
        List<Category> categorys = categoryService.getcategory();
        //获得该用户下的购物项
        List<Shopcaritems> shopcaritemsList = shopcarService.getshopcaritemsbyuserid(user.getId());
        if(shopcaritemsList!=null){
            for(Category c:categorys){
                //获得每个分类下的商品
                List<Product> products = productService.getproductinfoByCategoryid(c.getId());
                //判断这个商品是否已经在购物项中，如果在显示数量
                for(Product p:products){
                    boolean flag=true;
                    for(Shopcaritems sc:shopcaritemsList){
                        if(p.getId()==sc.getProductid()){
                            flag=false;
                            p.setProductcount(sc.getProductcount());
                            break;
                        }
                    }
                    if(flag){
                        p.setProductcount(0);
                    }
                }
                c.setProducts(products);
            }
        }else{
            for(Category c:categorys){
                //获得每个分类下的商品
                List<Product> products = productService.getproductinfoByCategoryid(c.getId());
                c.setProducts(products);
            }
        }
        Shopcar shopc=new Shopcar();
        shopc.setUserid(user.getId());
        Shopcar shopcar = shopcarService.getshopcarbyuserid(shopc);
        if(shopcar!=null){
            shopcar.setShopcaritemscount(shopcaritemsList.size());
            model.addAttribute("shopcar",shopcar);
            model.addAttribute("categorys",categorys);
        }else{
            Shopcar shopc1=new Shopcar();
            shopc1.setTotalprice(0.0);
            shopc1.setShopcaritemscount(0);
            model.addAttribute("categorys",categorys);
            model.addAttribute("shopcar",shopc1);
        }
        model.addAttribute("discuss",disscusses);
        return "/market/supermarket";
    }

    //跳转到购物车页面（添加到购物车）
    @PostMapping("shopcaritems")
    @ResponseBody
    public Map shopcaritems(@RequestBody List<Shopcaritems> list, HttpServletRequest request){
        HttpSession session = request.getSession();
        //获得登录用户
        User user =(User) session.getAttribute("user");
        Shopcar checkshopcar1=new Shopcar();
        checkshopcar1.setUserid(user.getId());
        double totalprice;
        Shopcar getshopcarbyuserid1 = shopcarService.getshopcarbyuserid(checkshopcar1);
        if(getshopcarbyuserid1!=null){
            totalprice=getshopcarbyuserid1.getTotalprice();
        }else{
            totalprice=0;
        }
        //从前台获得购物项详细信息
        for(int i=0;i<list.size();i++){
            Shopcaritems sp=new Shopcaritems();
            //获得购物项数量
            sp.setProductcount(list.get(i).getProductcount());
            //获得购物项中商品信息
            Product product = productService.getproductinfoById(list.get(i).getProductid());
            double producttotalprice;
            double newprice;
            //查找购物项中是否已经存在该商品
            Shopcaritems getshopcaritemsbyproductid = shopcarService.getshopcaritemsbyproductid(list.get(i).getProductid());
            if(getshopcaritemsbyproductid!=null){
                int count=0;
                Integer productcount = getshopcaritemsbyproductid.getProductcount();
                Integer newproductcount = list.get(i).getProductcount();
                count=productcount-newproductcount;
                if(count>0){
                    newprice=product.getPrice()*(newproductcount-productcount);
                    producttotalprice=getshopcaritemsbyproductid.getProducttotalprice()+newprice;
                    sp.setProductcount(newproductcount);
                }else{
                    newprice=product.getPrice()*(newproductcount-productcount);
                    producttotalprice=getshopcaritemsbyproductid.getProducttotalprice()+newprice;
                    sp.setProductcount(newproductcount);
                }
                //计算购物车总价
                totalprice=totalprice+newprice;
            }else{
                producttotalprice=product.getPrice()*list.get(i).getProductcount();
                //计算购物车总价
                totalprice=totalprice+producttotalprice;
            }
            //获得购物项价格

            sp.setProducttotalprice(producttotalprice);
            sp.setProductid(list.get(i).getProductid());
            sp.setUserid(user.getId());
            //查看购物项中是否已经存在这个商品如果有执行修改操作，没有做增加操作
            List<Shopcaritems> checkshopitems = shopcarService.getshopcaritemsbyuserid(user.getId());
            boolean flag=true;
            for(int j=0;j<checkshopitems.size();j++){
                if(checkshopitems.get(j).getProductid()==list.get(i).getProductid()){
                    flag=false;
                    break;
                }else{
                    continue;
                }
            }
            if(flag){
                //增加购物项
                int addshopcaritems = shopcarService.addshopcaritems(sp);
            }else{
                //作购物项的修改
                int updatebyproductid = shopcarService.updatebyproductid(sp);
            }
        }

        //获得这个用户的购物项
        List<Shopcaritems> shopcaritems = shopcarService.getshopcaritemsbyuserid(user.getId());
        StringBuffer s=new StringBuffer();
        //将这个用户下的商品名字保存进去
        for(int k=0;k<shopcaritems.size();k++){
            Shopcaritems cs=new Shopcaritems();
            Product product = productService.getproductinfoById(shopcaritems.get(k).getProductid());
            cs.setProductname(product.getProductname());
            cs.setProductid(product.getId());
            int kk = shopcarService.updateshopcaritemsproductnamebyproductid(cs);
        }
        //获得购物项id集
        for(int j=0;j<shopcaritems.size();j++){
            if(j==shopcaritems.size()-1){
                s.append(shopcaritems.get(j).getId());
            }else{
                s.append(shopcaritems.get(j).getId()+",");
            }
        }
        Shopcar sc=new Shopcar();
        sc.setItemsid(s.toString());
        sc.setUserid(user.getId());
        sc.setTotalprice(totalprice);
        //将这个用户的购物车信息保存到数据库
        Shopcar checkshopcar = shopcarService.getshopcarbyuserid(sc);
        //查看购物车中是否已经有该用户的购物车信息
        if(checkshopcar!=null){
            //如果存在执行修改购物车信息操作
            int updateshopcarbyuserid = shopcarService.updateshopcarbyuserid(sc);
        }else{
            //不存在执行添加购物车信息
            int addshopcar = shopcarService.addshopcar(sc);
        }
        Shopcar spc=new Shopcar();
        spc.setUserid(user.getId());
        //获得该用户购物车中最新消息
        Shopcar getshopcarbyuserid = shopcarService.getshopcarbyuserid(spc);
        String itemsid = getshopcarbyuserid.getItemsid();
        String[] split = itemsid.split(",");
        //将购物项集转成集合
        List list1=new ArrayList();
        for(int jj=0;jj<split.length;jj++){
            list1.add(split[jj]);
        }
        //查到购物车里的购物项
        List<Shopcaritems> getshopcaritemsbyid = shopcarService.getshopcaritemsbyid(list1);
        //添加到最新的购物车实体类中，用于传到页面
        getshopcarbyuserid.setShopcaritems(getshopcaritemsbyid);
        Map map=new HashMap();
        map.put("shopcar",getshopcarbyuserid);
        return map;
    }


    //在购物车页面删除购物项与购物车
    @RequestMapping("deleteshopcaritems")
    @ResponseBody
    public String deleteshopcaritems(HttpServletRequest request){
        String productid = request.getParameter("productid");
        String oldprice = request.getParameter("oldprice");
        String id = request.getParameter("id");
        Shopcar shopcar=new Shopcar();
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        shopcar.setUserid(user.getId());
        //查找购物车
        Shopcar sp = shopcarService.getshopcarbyuserid(shopcar);
        //获得新的总价
        double newTotalprice=sp.getTotalprice()-Double.parseDouble(oldprice);
        //获得新产itemsid集
        String itemsid = sp.getItemsid();
        //删除没用的productid
        String[] split = itemsid.split(",");
        List list=new ArrayList();
        for(int j=0;j<split.length;j++){
            list.add(split[j]);
        }
        StringBuffer newitems=new StringBuffer();
        //查看是否有要删除的productid
        for(int jj=0;jj<list.size();jj++){
            if(list.get(jj).equals(id)){
                list.remove(list.get(jj));
            }
        }
        for(int jjj=0;jjj<list.size();jjj++){
            if(jjj==0){
                newitems.append(list.get(jjj));
            }else{
                if(jjj==list.size()-1){
                    newitems.append(list.get(jjj));
                }else{
                    newitems.append(",");
                    newitems.append(list.get(jjj));
                }


            }
        }
        shopcar.setTotalprice(newTotalprice);
        shopcar.setItemsid(newitems.toString());
        //修改最新的购物车
        shopcarService.updateshopcarbyuserid(shopcar);
        int i = shopcarService.deleteshopcaritemsbyproductid(Integer.parseInt(productid));
        int k = shopcarService.getcountshopcaritems(user.getId());
        if(k==0){
            shopcarService.deleteshopcarbyuserid(user.getId());
        }
        return "success";
    }

    //修改购物项单项总价
    @RequestMapping("uproducttotal")
    @ResponseBody
    public String uproducttotal(HttpServletRequest request){
        String productid = request.getParameter("productid");
        String totalprice = request.getParameter("totalprice");
        String productcount = request.getParameter("productcount");
        Shopcaritems si=new Shopcaritems();
        si.setProductid(Integer.parseInt(productid));
        si.setProducttotalprice(Double.parseDouble(totalprice));
        si.setProductcount(Integer.parseInt(productcount));
        int i = shopcarService.updatebyproductid(si);
        if(i>0){
            return "success";
        }else{
            return "faild";
        }
    }

    //跳转到结算页面
    @RequestMapping("toorder")
    public String toorder(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        //从session得到用户
        User user = (User)session.getAttribute("user");
        Shopcar shopcar=new Shopcar();
        shopcar.setUserid(user.getId());
        //获得该用户的购物车信息
        Shopcar sp = shopcarService.getshopcarbyuserid(shopcar);
        String itemsid = sp.getItemsid();
        String[] split = itemsid.split(",");
        List list=new ArrayList();
        for(int i=0;i<split.length;i++){
            list.add(split[i]);
        }
        //获得该用户购物车中的购物项
        double tp=0;
        List<Shopcaritems> shopcaritems = shopcarService.getshopcaritemsbyid(list);
        for(Shopcaritems spi:shopcaritems){
            tp=tp+spi.getProducttotalprice();
        }
        sp.setShopcaritems(shopcaritems);
        sp.setTotalprice(tp);
        model.addAttribute("user",user);
        model.addAttribute("shopcar",sp);
        return "/market/confirmorder";
    }


    //跳转到支付页面
    @RequestMapping("toplay")
    public String toplay(HttpServletRequest request,
                         Model model){
        String id = request.getParameter("id");
        if(id!=null && id!=""){
            Order getorderbyid = orderService.getorderbyid(Integer.parseInt(id));
            model.addAttribute("order",getorderbyid);
            return "/market/play";
        }else{
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String time = request.getParameter("time");
            String totalprice = request.getParameter("totalprice");
            String play = request.getParameter("play");
            Order order=new Order();
            order.setAddress(address);
            order.setName(name);
            order.setTime(time);
            order.setTotalprice(Double.parseDouble(totalprice));
            order.setPlay(play);
            order.setPlaystatu(0);
            order.setReback(0);
            Date date=new Date();
            StringBuffer orderid=new StringBuffer();
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            order.setCreatetime(format.format(date));
            //获得模块图片
            List<Limit> limits = userService.getLimits();
            String path = limits.get(0).getPath();
            order.setPath(path);
            //获得登录用户信息
            HttpSession session = request.getSession();
            User user =(User) session.getAttribute("user");
            //获得商品列表
            int count=0;
            List<Shopcaritems> shopcaritems = shopcarService.getshopcaritemsbyuserid(user.getId());
            StringBuffer shoplist=new StringBuffer();
            for(int i=0;i<shopcaritems.size();i++){
                count=count+shopcaritems.get(i).getProductcount();
                StringBuffer a=new StringBuffer();
                String productname = shopcaritems.get(i).getProductname();
                Double producttotalprice = shopcaritems.get(i).getProducttotalprice();
                Integer productcount = shopcaritems.get(i).getProductcount();
                a.append(productname);
                a.append(",");
                a.append(producttotalprice);
                a.append(",");
                a.append(productcount);
                shoplist.append(a);
                if(i==shopcaritems.size()-1){
                    shoplist.append("");
                }else{
                    shoplist.append(":");
                }
            }
            //获得购订单编号
            StringBuffer od=new StringBuffer("SQCS");
            //自增量
            od.append(shopcaritems.get(0).getProductid());
            od.append(new Date());
            od.append(user.getCommunityid());
            order.setOrderid(od.toString());
            order.setCount(count);
            order.setShoplist(shoplist.toString());
            order.setUserid(user.getId());
            order.setPhonenumber(user.getPhoneNumber());
            order.setCommunityid(user.getCommunityid());
            //支付成功保存入订单表
            orderService.addorder(order);
            shopcarService.deleteshopcaritemsbyuserid(user.getId());
            shopcarService.deleteshopcarbyuserid(user.getId());
            model.addAttribute("order",order);
            return "/market/play";
        }

    }


    //跳转到订单页
    @RequestMapping("showorder")
    public String showorder(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Order> shoporders = orderService.getorderbyuserid(user.getId());
        //获得商品列表
        for(int i=0;i<shoporders.size();i++){
            String shoplist = shoporders.get(i).getShoplist();
            String[] s1 = shoplist.split(":");
            List<Shopcaritems> list=new ArrayList<Shopcaritems>();
            for(int j=0;j<s1.length;j++){
                Shopcaritems sp=new Shopcaritems();
                String[] s2 = s1[j].split(",");
                sp.setProductname(s2[0]);
                sp.setProducttotalprice(Double.parseDouble(s2[1]));
                sp.setProductcount(Integer.parseInt(s2[2]));
                list.add(sp);
            }
            shoporders.get(i).setShopcaritems(list);
        }
        model.addAttribute("shoporders",shoporders);
        return "/market/order";
    }


    //支付成功后修改商品信息
    @RequestMapping("play")
    @ResponseBody
    public String play(HttpServletRequest request){
        String shoplist = request.getParameter("shoplist");
        String orderid = request.getParameter("orderid");
        Order order=new Order();
        order.setOrderid(orderid);
        order.setPlaystatu(1);
        order.setSendstatu(2);
        order.setEvaluatestatu(0);
        String[] s1 = shoplist.split(":");
        //支付后，修改商品库存
        for(int j=0;j<s1.length;j++){
            Product product=new Product();
            Shopcaritems sp=new Shopcaritems();
            String[] s2 = s1[j].split(",");
            product.setProductname(s2[0]);
            double price=Double.parseDouble(s2[1])/Double.parseDouble(s2[2]);
            System.out.print(price);
            product.setPrice(price);
            Product product1 = productService.getproductbynameprice(product);
            Integer oldstore = product1.getStore();
            product.setStore(oldstore-Integer.parseInt(s2[2]));
            productService.updateproductbynameprice(product);
        }
        int i = orderService.updateplaystatu(order);
        return "success";
    }


    //跳转到评价页面
    @RequestMapping("todiscuss")
    public String todiscuss(HttpServletRequest request,Model model){
        String id = request.getParameter("id");
        model.addAttribute("id",id);
        return "/market/discuss";
    }

    //评论
    @RequestMapping("discuss")
    @ResponseBody
    public String discuss(HttpServletRequest request){
        String content = request.getParameter("content");
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        String id = request.getParameter("id");
        String img = request.getParameter("img");
        Disscuss dis=new Disscuss();
        dis.setContent(content);
        dis.setModelid(1);
        dis.setPath(img);
        dis.setUserid(user.getId());
        dis.setName(user.getName());
        dis.setCommunityid(user.getCommunityid());
        Date d=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dis.setCreatetime(format.format(d));
        int i = disscussService.adddisscuss(dis);
        Order order=new Order();
        order.setId(Integer.parseInt(id));
        order.setEvaluatestatu(1);
        if(i>0){
            int j = orderService.updateotherstatubyid(order);
            if(j>0){
                return "success";
            }else{
                return "faild";
            }

        }else{
            return "faild";
        }
    }
    @RequestMapping("todiscussone")
    public String discussone(HttpServletRequest request){
        String id = request.getParameter("id");
        Order order=new Order();
        order.setId(Integer.parseInt(id));
        order.setSendstatu(1);
        int i = orderService.updateotherstatubyid(order);
        return "redirect:/market/showorder";
    }

    //七牛
    @RequestMapping("token")
    @ResponseBody
    public String token(){
        String token = this.qiniuUploadService.getUploadToken();
        return token;
    }

    //申请退款
    @RequestMapping("reback")
    @ResponseBody
    public String reback(HttpServletRequest request){
        String id = request.getParameter("id");
        Order order=new Order();
        order.setReback(1);
        order.setId(Integer.parseInt(id));
        int i = orderService.updateotherstatubyid(order);
        if(i>0){
            return "success";
        }else{
            return "faild";
        }
    }
}
