package com.shigan.service.pm;

import com.shigan.pojo.pm.Xqgg;

import java.util.List;

/**
 * Created by Administrator on 2017/7/27.
 */
public interface XqggService {

    //<!--根据小区Id查小区公告-->
    public List<Xqgg> getggbycommunityid(Integer communityid);


    //根据公告id查看公告详细信息
    public Xqgg getgginfobyid(Integer id);
}
