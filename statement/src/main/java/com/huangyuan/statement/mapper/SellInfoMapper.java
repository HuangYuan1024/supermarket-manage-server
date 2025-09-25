package com.huangyuan.statement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huangyuan.statement.entity.SellInfo;
import com.huangyuan.statement.entity.dto.DayTurnoverDTO;
import com.huangyuan.statement.entity.dto.MonthTurnoverDTO;
import com.huangyuan.statement.entity.dto.WeekTurnoverDTO;
import com.huangyuan.statement.entity.dto.YearTurnoverDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    @Select("SELECT DATE(s_time) AS date, SUM(s_quantity * c_price) AS turnover " +
            "FROM sell_info si " +
            "JOIN goods g ON si.s_c_number = g.c_number " +
            "GROUP BY DATE(s_time) " +
            "ORDER BY date")
    List<DayTurnoverDTO> turnoverEveryDay();

    @Select("SELECT DATE_SUB(DATE(s_time), INTERVAL WEEKDAY(s_time)+1 DAY) AS sdate, " +
            "DATE_ADD(DATE(s_time), INTERVAL (6 - WEEKDAY(s_time)) DAY) AS edate, " +
            "SUM(s_quantity * c_price) AS turnover " +
            "FROM sell_info si " +
            "JOIN goods g ON si.s_c_number = g.c_number " +
            "GROUP BY DATE_SUB(DATE(s_time), INTERVAL WEEKDAY(s_time)+1 DAY), " +
            "DATE_ADD(DATE(s_time), INTERVAL (6 - WEEKDAY(s_time)) DAY) " +
            "ORDER BY sdate")
    List<WeekTurnoverDTO> turnoverEveryWeek();

    @Select("SELECT YEAR(s_time)  AS year, " +
            "MONTH(s_time) AS month, " +
            "SUM(s_quantity * c_price) AS turnover " +
            "FROM sell_info si " +
            "JOIN goods g ON si.s_c_number = g.c_number " +
            "WHERE s_time IS NOT NULL " +
            "GROUP BY YEAR(s_time), MONTH(s_time) " +
            "ORDER BY year, month")
    List<MonthTurnoverDTO> turnoverEveryMonth();

    @Select("SELECT YEAR(s_time) AS year, " +
            "SUM(s_quantity * c_price) AS turnover " +
            "FROM sell_info si " +
            "JOIN goods g ON si.s_c_number = g.c_number " +
            "GROUP BY year " +
            "ORDER BY year")
    List<YearTurnoverDTO> turnoverEveryYear();
}
