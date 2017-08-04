package com.shigan.service.serviceImpl.pm;

import com.shigan.mapper.PmMapper;
import com.shigan.pojo.pm.Wybx;
import com.shigan.service.pm.WybxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/7/27.
 */
@Service
public class WybxServiceImpl implements WybxService {

    @Autowired
    private PmMapper pmMapper;
    @Override
    public List<Wybx> getwybxbycommunityid(Integer community) {
        List<Wybx> wybxes = pmMapper.getwybxbycommunityid(community);
        return wybxes;
    }

    @Transactional
    @Override
    public int addbx(Wybx wybx) {
        int i = pmMapper.addbx(wybx);
        return i;
    }

    //确认报修
    @Override
    public int confirmbx(Wybx wybx) {
        int i = pmMapper.confirmbx(wybx);
        return i;
    }


}
