package com.shigan.controller;

import com.shigan.pojo.Ad;
import com.shigan.pojo.Limit;
import com.shigan.pojo.User;
import com.shigan.service.UserService;
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
    private UserService userService;
    //跳转到首页
    @RequestMapping("")
    public String firstPage(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
       User user = (User)session.getAttribute("user");
       if(user==null){
           model.addAttribute("stat","nologin");
       }else{
           model.addAttribute("stat","login");
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
