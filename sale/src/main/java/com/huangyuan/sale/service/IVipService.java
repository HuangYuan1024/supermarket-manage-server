package com.huangyuan.sale.service;

import com.huangyuan.sale.entity.Vip;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huangyuan
 * @since 2025-08-12
 */
public interface IVipService extends IService<Vip> {

    boolean addScore(String vipNo, int points);

}
