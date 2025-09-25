package com.huangyuan.sale.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huangyuan.sale.entity.Goods;
import com.huangyuan.sale.mapper.GoodsMapper;
import com.huangyuan.sale.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huangyuan
 * @since 2025-08-12
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public boolean deductInventory(Integer skuId, Integer qty) {
        return goodsMapper.deductInventory(skuId, qty) > 0;
    }

    @Override
    public BigDecimal selectPrice(Integer skuId) {
        return goodsMapper.selectPrice(skuId);
    }

    @Override
    public int getInventory(Integer skuId) {
        return goodsMapper.getInventory(skuId);
    }
}
