package com.huangyuan.statement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huangyuan.statement.entity.SellInfo;
import com.huangyuan.statement.entity.dto.DayTurnoverDTO;
import com.huangyuan.statement.entity.dto.MonthTurnoverDTO;
import com.huangyuan.statement.entity.dto.WeekTurnoverDTO;
import com.huangyuan.statement.entity.dto.YearTurnoverDTO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huangyuan
 * @since 2025-08-12
 */
public interface ISellInfoService extends IService<SellInfo> {

    List<DayTurnoverDTO> turnoverEveryDay();

    List<WeekTurnoverDTO> turnoverEveryWeek();

    List<MonthTurnoverDTO> turnoverEveryMonth();

    List<YearTurnoverDTO> turnoverEveryYear();
}
