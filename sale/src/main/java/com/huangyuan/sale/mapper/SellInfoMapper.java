package com.huangyuan.sale.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huangyuan.sale.entity.SellInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huangyuan
 * @since 2025-08-12
 */
@Mapper
public interface SellInfoMapper extends BaseMapper<SellInfo> {

    @Insert("INSERT INTO sell_info (s_c_number, s_quantity, s_time, s_e_number, s_vip_number) VALUES (#{skuId}, #{qty}, #{sellTime}, #{empNo}, #{vipNo})")
    int insertSellRecord(@Param("skuId") Integer skuId, @Param("qty") Integer qty, @Param("sellTime") LocalDate sellTime, @Param("empNo") String empNo, @Param("vipNo") String vipNo);

}
