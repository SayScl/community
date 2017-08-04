package com.shigan.service.serviceImpl.pm;

import com.shigan.mapper.PmMapper;
import com.shigan.pojo.pm.Wyzs;
import com.shigan.pojo.pm.Xfzx;
import com.shigan.service.pm.WyzsService;
import com.shigan.service.pm.XfzxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/27.
 */
@Service
public class XfzxServiceImpl implements XfzxService {
    @Autowired
    private PmMapper pmMapper;
    //查询装修案例
    @Override
    public List<Xfzx> getzxbycommunityid(Integer communityid) {
        List<Xfzx> getzxbycommunityid = pmMapper.getzxbycommunityid(communityid);
        return getzxbycommunityid;
    }


    //查询装修案例详情
    @Override
    public Xfzx getzxinfobyid(Integer id) {
        Xfzx getgginfobyid = pmMapper.getzxinfobyid(id);
        return getgginfobyid;
    }

    @Override
    public int upzxinfohot(Xfzx xfzx) {
        int i = pmMapper.upzxinfohot(xfzx);
        return i;
    }
}
