package com.shigan.controller;

import com.shigan.pojo.Ad;
import com.shigan.pojo.Limit;
import com.shigan.pojo.User;
import com.shigan.pojo.pm.Xqgg;
import com.shigan.service.UserService;
import com.shigan.service.pm.XqggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */
@Controller
public class FirstPageController {
    @Autowired
    private XqggService xqggService;
    @Autowired
    private UserService userService;
    //跳转到首页
    @RequestMapping("")
    public String firstPage(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        Integer communityid=null;
       User user = (User)session.getAttribute("user");
       if(user==null){
           model.addAttribute("stat","nologin");
       }else{
           model.addAttribute("stat","login");
           communityid = user.getCommunityid();
       }
       if(communityid!=null){
           List<Xqgg> ggs = xqggService.getggbycommunityid(communityid);
           model.addAttribute("gg",ggs.get(0));
       }

        List<Limit> limits = userService.getLimits();
       model.addAttribute("limits",limits);
        Ad ad = new Ad();
        ad.setAdlocationid(1);
        List<Ad> ads = userService.getAdByAdId(ad);
        model.addAttribute("list",ads);
        return "firstPage";
    }
}
