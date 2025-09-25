package com.huangyuan.sale.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huangyuan.sale.entity.Vip;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
public interface VipMapper extends BaseMapper<Vip> {

    @Update("UPDATE vip SET v_score = v_score + #{points} WHERE v_number = #{vipNo}")
    int addScore(@Param("vipNo") String vipNo, @Param("points") int points);

}
