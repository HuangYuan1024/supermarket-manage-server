package com.huangyuan.sale.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * <p>
 * 
 * </p>
 *
 * @author huangyuan
 * @since 2025-08-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("clock_info")
public class ClockInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "clock_id", type = IdType.AUTO)
    private Integer clockId;

    @TableField(value = "employee_no")
    private String employeeNo;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "clock_in_time")
    private Timestamp clockInTime;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "clock_off_time")
    private Timestamp clockOffTime;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @TableField(value = "clock_date")
    private Timestamp clockDate;

}
