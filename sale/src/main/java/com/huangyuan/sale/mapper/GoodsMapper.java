package com.huangyuan.sale.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huangyuan.sale.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huangyuan
 * @since 2025-08-12
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

    @Select("SELECT inventory FROM goods WHERE c_number = #{skuId}")
    Integer getInventory(@Param("skuId") int skuId);

    @Update("UPDATE goods SET inventory = inventory - #{qty} WHERE c_number = #{skuId}")
    int deductInventory(@Param("skuId") int skuId, @Param("qty") int qty);

    @Select("SELECT c_price FROM goods WHERE c_number = #{skuId}")
    java.math.BigDecimal selectPrice(@Param("skuId") int skuId);
}
