package com.shigan.service.pm;

import com.shigan.pojo.pm.Wyzs;
import com.shigan.pojo.pm.Xqgg;

import java.util.List;

/**
 * Created by Administrator on 2017/7/27.
 */
public interface WyzsService {

    //<!--根据小区Id查小区公告-->
    public List<Wyzs> getzsbycommunityid(Integer communityid);


    //根据公告id查看公告详细信息
    public Wyzs getzsinfobyid(Integer id);
}
