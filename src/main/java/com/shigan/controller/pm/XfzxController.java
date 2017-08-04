package com.shigan.controller.pm;

import com.shigan.pojo.User;
import com.shigan.pojo.pm.Xfzx;
import com.shigan.pojo.pm.Xqgg;
import com.shigan.service.pm.XfzxService;
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
public class XfzxController {

    @Autowired
    private XfzxService xfzxService;
    //跳转装修案例页
    @RequestMapping("toxfzx")
    public String toxfzx(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        List<Xfzx> getggbycommunityid = xfzxService.getzxbycommunityid(user.getCommunityid());
        model.addAttribute("xfzx",getggbycommunityid);
        return "/pm/xfzx";
    }

    //跳转到案例详情页
    @RequestMapping("tozxinfo")
    public String togginfo(@PathParam("id") Integer id,@PathParam("hot") Integer hot, Model model){
        Xfzx xfzx=new Xfzx();
        xfzx.setId(id);
        xfzx.setHot(hot+1);
        int i = xfzxService.upzxinfohot(xfzx);
        Xfzx getgginfobyid = xfzxService.getzxinfobyid(id);
        model.addAttribute("xfzx",getgginfobyid);
        return "/pm/zxinfo";
    }
}
