package com.huangyuan.statement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huangyuan.statement.entity.SellInfo;
import com.huangyuan.statement.entity.dto.DayTurnoverDTO;
import com.huangyuan.statement.entity.dto.MonthTurnoverDTO;
import com.huangyuan.statement.entity.dto.WeekTurnoverDTO;
import com.huangyuan.statement.entity.dto.YearTurnoverDTO;
import com.huangyuan.statement.mapper.SellInfoMapper;
import com.huangyuan.statement.service.ISellInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<DayTurnoverDTO> turnoverEveryDay() {
        return sellInfoMapper.turnoverEveryDay();
    }

    @Override
    public List<WeekTurnoverDTO> turnoverEveryWeek() {
        return sellInfoMapper.turnoverEveryWeek();
    }

    @Override
    public List<MonthTurnoverDTO> turnoverEveryMonth() {
        return sellInfoMapper.turnoverEveryMonth();
    }

    @Override
    public List<YearTurnoverDTO> turnoverEveryYear() {
        return sellInfoMapper.turnoverEveryYear();
    }
}
