package com.huangyuan.sale.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huangyuan.sale.entity.SellInfo;

import java.time.LocalDate;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huangyuan
 * @since 2025-08-12
 */
public interface ISellInfoService extends IService<SellInfo> {

    boolean insertSellRecord(Integer skuId, Integer qty, LocalDate sellTime, String empNo, String vipNo);

}
