package com.shigan.service.serviceImpl.pm;

import com.shigan.mapper.PmMapper;
import com.shigan.pojo.pm.Se;
import com.shigan.pojo.pm.Usertp;
import com.shigan.pojo.pm.Xqtp;
import com.shigan.service.pm.XqtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 */
@Service
public class XqtpServiceImpl implements XqtpService {
    @Autowired
    private PmMapper pmMapper;
    @Override
    public List<Xqtp> gettpbycommunityid(Integer communityid) {
        List<Xqtp> gettpbycommunityid = pmMapper.gettpbycommunityid(communityid);
        return gettpbycommunityid;
    }

    @Override
    public Xqtp gettpbyid(Integer id) {
        Xqtp gettpbyid = pmMapper.gettpbyid(id);
        return gettpbyid;
    }

    @Override
    public List<Se> getsebytid(Integer tid) {
        List<Se> getsebytid = pmMapper.getsebytid(tid);
        return getsebytid;
    }

    @Override
    public Se getsebyid(Integer id) {
        Se getsebyid = pmMapper.getsebyid(id);
        return getsebyid;
    }

    @Override
    public int upsebyid(Se se) {
        int upsebyid = pmMapper.upsebyid(se);
        return upsebyid;
    }

    @Override
    public List<Usertp> gettpbyuserid(Integer userid) {
        List<Usertp> gettpbyuserid = pmMapper.gettpbyuserid(userid);
        return gettpbyuserid;
    }

    @Override
    public int addusertp(Usertp usertp) {
        int i = pmMapper.addusertp(usertp);
        return i;
    }


}
