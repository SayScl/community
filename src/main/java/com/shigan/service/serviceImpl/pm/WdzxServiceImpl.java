package com.shigan.service.serviceImpl.pm;

import com.shigan.mapper.PmMapper;
import com.shigan.pojo.pm.Wdzx;
import com.shigan.service.pm.WdzxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@Service
public class WdzxServiceImpl implements WdzxService {
    @Autowired
    private PmMapper pmMapper;
    @Override
    public List<Wdzx> getwdzx(Integer userid) {
        List<Wdzx> getwdzx = pmMapper.getwdzx(userid);
        return getwdzx;
    }
}
