package com.shigan.service.pm;

import com.shigan.pojo.pm.Wybx;

import java.util.List;

/**
 * Created by Administrator on 2017/7/27.
 */
public interface WybxService {

    //降序查询出所有报修
    public List<Wybx> getwybxbycommunityid(Integer community);


    //<!--增加新报修-->
    public int addbx(Wybx wybx);

    //<!--确认报修-->
    public int confirmbx(Wybx wybx);
}
