package com.huangyuan.statement.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 每日营业额视图对象
 */
@Data
public class DayTurnoverDTO {
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Timestamp date;      // 销售日期

    private BigDecimal turnover; // 当日营业额
}
