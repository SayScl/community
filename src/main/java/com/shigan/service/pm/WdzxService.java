package com.shigan.service.pm;

import com.shigan.pojo.pm.Wdzx;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
public interface WdzxService {
    //<!--根据userid查找我的装修进度-->
    public List<Wdzx> getwdzx(Integer userid);
}
