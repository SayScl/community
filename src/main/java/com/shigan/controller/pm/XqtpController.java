package com.shigan.controller.pm;

import com.shigan.common.Common;
import com.shigan.pojo.User;
import com.shigan.pojo.pm.Se;
import com.shigan.pojo.pm.Usertp;
import com.shigan.pojo.pm.Xqtp;
import com.shigan.service.pm.XqtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 */
@Controller
@RequestMapping("pm")
public class XqtpController {
    @Autowired
    private XqtpService xqtpService;
    @RequestMapping("toxqtp")
    public String toxqtp(Model model){
        User user = Common.user;
        List<Xqtp> gettpbycommunityid = xqtpService.gettpbycommunityid(user.getCommunityid());
        model.addAttribute("xqtp",gettpbycommunityid);
        return "/pm/xqtp";
    }

    //跳转到投票详情页
    @RequestMapping("totpinfo")
    public String totpinfo(HttpServletRequest request,Model model) throws ParseException {
        User user = Common.user;
        //获得当前时间
        Calendar ca=Calendar.getInstance();
        ca.setTime(new Date());
        int day = ca.get(Calendar.DAY_OF_MONTH);
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH);
        String id = request.getParameter("id");
        Xqtp gettpbyid = xqtpService.gettpbyid(Integer.parseInt(id));
        //获得投票失效时间
        String limittime = gettpbyid.getLimittime();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date limitdate = sdf.parse(limittime);
        Calendar limitca=Calendar.getInstance();
        limitca.setTime(limitdate);
        //取失效时间的年月日
        int lday = limitca.get(Calendar.DAY_OF_MONTH);
        int lyear = limitca.get(Calendar.YEAR);
        int lmonth = limitca.get(Calendar.MONTH);

        List<Se> getsebytid = xqtpService.getsebytid(gettpbyid.getId());
        gettpbyid.setLse(getsebytid);
        model.addAttribute("xqtp",gettpbyid);
        if(year<=lyear){
            if(month<=lmonth){
                if(day<=lday){
                    //查看用户是否已经投过
                    List<Usertp> gettpbyuserid = xqtpService.gettpbyuserid(user.getId());
                    for(Usertp up:gettpbyuserid){
                        if(up.getTid()==gettpbyid.getId()){
                            return "/pm/tpinfo";
                        }
                    }
                    return "/pm/tpinfo1";
                }else{
                    return "/pm/tpinfo";
                }
            }else{
                return "/pm/tpinfo";
            }
        }else{
            return "/pm/tpinfo";
        }
    }


    //投票
    @RequestMapping("tp")
    @ResponseBody
    public String tp(HttpServletRequest request){
        User user = Common.user;
        String id = request.getParameter("id");
        String tid = request.getParameter("tid");
        Usertp ut=new Usertp();
        ut.setUserid(user.getId());
        ut.setTid(Integer.parseInt(tid));
        int k = xqtpService.addusertp(ut);
        //得到具体投了哪些项
        String[] split = id.split(",");
        for(int i=0;i<split.length;i++){
            Se se=new Se();
            Se se1 = xqtpService.getsebyid(Integer.parseInt(split[i]));
            se.setProgress(se1.getProgress()+1);
            se.setId(Integer.parseInt(split[i]));
            int upsebyid = xqtpService.upsebyid(se);
        }
        return "success";
    }
}
