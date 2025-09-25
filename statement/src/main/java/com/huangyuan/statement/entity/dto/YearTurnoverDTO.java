package com.huangyuan.statement.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 每日营业额视图对象
 */
@Data
public class YearTurnoverDTO {
    private Integer year;         // 年
    private BigDecimal turnover;  // 当年营业额
}