package com.huangyuan.sale.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huangyuan.sale.entity.Vip;
import com.huangyuan.sale.mapper.VipMapper;
import com.huangyuan.sale.service.IVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huangyuan
 * @since 2025-08-12
 */
@Service
public class VipServiceImpl extends ServiceImpl<VipMapper, Vip> implements IVipService {

    @Autowired
    private VipMapper vipMapper;

    @Override
    public boolean addScore(String vipNo, int points) {
        return vipMapper.addScore(vipNo, points) > 0;
    }

}
