package com.shigan.service.serviceImpl.pm;

import com.shigan.mapper.PmMapper;
import com.shigan.pojo.pm.Kjcz;
import com.shigan.service.pm.KjczService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@Service
public class KjczServiceImpl implements KjczService {
    @Autowired
    private PmMapper pmMapper;
    @Override
    public int addcz(Kjcz cz) {
        int i = pmMapper.addcz(cz);
        return i;
    }

    @Override
    public List<Kjcz> getczbyuserid(Integer userid) {
        List<Kjcz> getczbyuserid = pmMapper.getczbyuserid(userid);
        return getczbyuserid;
    }
}
