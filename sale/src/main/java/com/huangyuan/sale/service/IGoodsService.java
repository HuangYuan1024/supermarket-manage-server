package com.huangyuan.sale.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huangyuan.sale.entity.Goods;

import java.math.BigDecimal;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huangyuan
 * @since 2025-08-12
 */
public interface IGoodsService extends IService<Goods> {
    boolean deductInventory(Integer skuId, Integer qty);
    BigDecimal selectPrice(Integer skuId);
    int getInventory(Integer skuId);
}
