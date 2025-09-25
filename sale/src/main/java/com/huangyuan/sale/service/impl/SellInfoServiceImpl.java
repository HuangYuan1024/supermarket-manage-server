package com.huangyuan.sale.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huangyuan.sale.entity.SellInfo;
import com.huangyuan.sale.mapper.SellInfoMapper;
import com.huangyuan.sale.service.ISellInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huangyuan
 * @since 2025-08-12
 */
@Service
public class SellInfoServiceImpl extends ServiceImpl<SellInfoMapper, SellInfo> implements ISellInfoService {

    @Autowired
    private SellInfoMapper sellInfoMapper;

    @Override
    public boolean insertSellRecord(Integer skuId, Integer qty, LocalDate sellTime, String empNo, String vipNo) {
        return sellInfoMapper.insertSellRecord(skuId, qty, sellTime, empNo, vipNo) > 0;
    }

}
