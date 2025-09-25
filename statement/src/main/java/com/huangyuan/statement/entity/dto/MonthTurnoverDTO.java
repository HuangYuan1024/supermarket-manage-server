package com.huangyuan.statement.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 每月营业额视图对象
 */
@Data
public class MonthTurnoverDTO {
    private Integer year;         // 年
    private Integer month;        // 月
    private BigDecimal turnover;  // 当月营业额
}
