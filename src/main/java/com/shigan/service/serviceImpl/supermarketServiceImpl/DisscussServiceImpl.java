package com.shigan.service.serviceImpl.supermarketServiceImpl;

import com.shigan.mapper.SupermarketMapper;
import com.shigan.pojo.supermarket.Disscuss;
import com.shigan.service.supermarketservice.DisscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/7/22.
 */
@Service
public class DisscussServiceImpl implements DisscussService {
    @Autowired
    private SupermarketMapper supermarketMapper;
    @Transactional
    @Override
    public int adddisscuss(Disscuss disscuss) {
        int i = supermarketMapper.adddisscuss(disscuss);
        return i;
    }

    @Override
    public List<Disscuss> getmarketdiscuss(Integer id) {
        List<Disscuss> getmarketdiscuss = supermarketMapper.getmarketdiscuss(id);
        return getmarketdiscuss;
    }
}
