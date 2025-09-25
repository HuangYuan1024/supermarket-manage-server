package com.huangyuan.statement.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 每周营业额视图对象
 */
@Data
public class WeekTurnoverDTO {
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Timestamp sdate;      // 起始日期（必须是周日开始）

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Timestamp edate;      // 结束日期（必须是周六结束）

    private BigDecimal turnover; // 当周营业额
}
