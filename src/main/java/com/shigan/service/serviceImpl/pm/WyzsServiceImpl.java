package com.shigan.service.serviceImpl.pm;

import com.shigan.mapper.PmMapper;
import com.shigan.pojo.pm.Wyzs;
import com.shigan.pojo.pm.Xqgg;
import com.shigan.service.pm.WyzsService;
import com.shigan.service.pm.XqggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/27.
 */
@Service
public class WyzsServiceImpl implements WyzsService {
    @Autowired
    private PmMapper pmMapper;
    //查询小区公告
    @Override
    public List<Wyzs> getzsbycommunityid(Integer communityid) {
        List<Wyzs> getggbycommunityid = pmMapper.getzsbycommunityid(communityid);
        return getggbycommunityid;
    }


    //查询公告详细信息
    @Override
    public Wyzs getzsinfobyid(Integer id) {
        Wyzs getgginfobyid = pmMapper.getzsinfobyid(id);
        return getgginfobyid;
    }
}
