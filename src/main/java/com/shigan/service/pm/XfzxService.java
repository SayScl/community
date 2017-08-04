package com.shigan.service.pm;

import com.shigan.pojo.pm.Wyzs;
import com.shigan.pojo.pm.Xfzx;

import java.util.List;

/**
 * Created by Administrator on 2017/7/27.
 */
public interface XfzxService {

    //<!--根据小区Id查小区公告-->
    public List<Xfzx> getzxbycommunityid(Integer communityid);


    //根据公告id查看公告详细信息
    public Xfzx getzxinfobyid(Integer id);

    //<!--修改装修案例热度-->
    public int upzxinfohot(Xfzx xfzx);
}
