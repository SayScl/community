package com.shigan.controller.pm;

import com.shigan.common.Common;
import com.shigan.pojo.User;
import com.shigan.pojo.pm.Kjcz;
import com.shigan.service.pm.KjczService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@Controller
@RequestMapping("/pm")
public class KjczController {
    @Autowired
    private KjczService kjczService;

    //充值
    @RequestMapping("addcz")
    @ResponseBody
    public String addcz(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");
        String money = request.getParameter("money");
        String type = request.getParameter("type");
        Kjcz cz=new Kjcz();
        cz.setCommunityid(user.getCommunityid());
        cz.setUserid(user.getId());
        cz.setMoney(Integer.parseInt(money));
        cz.setType(Integer.parseInt(type));
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        cz.setCreatetime(sd.format(new Date()));
        cz.setStatu(0);
        int i = kjczService.addcz(cz);
        if(i>0){
            return "success";
        }else{
            return "faild";
        }
    }

    //跳转到我的充值历史
    @RequestMapping("getczbyuserid")
    public String getcz(HttpServletRequest request, Model model){
        User user = Common.user;
        List<Kjcz> getczbyuserid = kjczService.getczbyuserid(user.getId());
        model.addAttribute("kjcz",getczbyuserid);
        return "/pm/czls";
    }
}
