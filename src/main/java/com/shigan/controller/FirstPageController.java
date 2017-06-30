package com.shigan.controller;

import com.shigan.pojo.Ad;
import com.shigan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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
    public String firstPage(Model model){
        Ad ad = new Ad();
        ad.setAdlocationid(1);
        List<Ad> ads = userService.getAdByAdId(ad);
        model.addAttribute("list",ads);
        return "firstPage";
    }
}
