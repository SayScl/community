package com.shigan.controller.pm;

import com.shigan.pojo.User;
import com.shigan.pojo.pm.Xqgg;
import com.shigan.service.pm.XqggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by Administrator on 2017/7/27.
 */
@Controller
@RequestMapping("pm")
public class XqggController {

    @Autowired
    private XqggService xqggService;
    //跳转到小区公告
    @RequestMapping("toxqgg")
    public String towybx(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        List<Xqgg> getggbycommunityid = xqggService.getggbycommunityid(user.getCommunityid());
        model.addAttribute("xqgg",getggbycommunityid);
        return "/pm/xqgg";
    }

    //跳转到公告详情页
    @RequestMapping("togginfo")
    public String togginfo(@PathParam("id") Integer id, Model model){
        Xqgg getgginfobyid = xqggService.getgginfobyid(id);
        model.addAttribute("xqgg",getgginfobyid);
        return "/pm/gginfo";
    }
}
