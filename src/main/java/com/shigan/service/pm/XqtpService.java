package com.shigan.service.pm;

import com.shigan.pojo.pm.Se;
import com.shigan.pojo.pm.Usertp;
import com.shigan.pojo.pm.Xqtp;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 */
public interface XqtpService {
    //<!--根据小区id查找投票-->
    public List<Xqtp> gettpbycommunityid(Integer communityid);


    //<!--根据id查找小区投票-->
    public Xqtp gettpbyid(Integer id);


    //<!--根据tid查找选项-->
    public List<Se> getsebytid(Integer tid);

    //<!--根据tid查找选项-->
    public Se getsebyid(Integer id);

    //<!--先改选项投票数-->
    public int upsebyid(Se se);

    //<!--根据用户id查投票-->
    public List<Usertp> gettpbyuserid(Integer userid);

    // <!--增加用户投票-->
    public int addusertp(Usertp usertp);
}
