package com.shigan.service.pm;

import com.shigan.pojo.pm.Kjcz;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
public interface KjczService {
    //<!--插入充值-->
    public int addcz(Kjcz cz);


    //<!--查找本人成功充值记录-->
    public List<Kjcz> getczbyuserid(Integer userid);
}
