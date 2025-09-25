package com.huangyuan.information.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

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
public class ClockInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "clock_id", type = IdType.AUTO)
    private Integer number;

    @TableField(value = "employee_no")
    private String employeeno;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "clock_in_time")
    private Timestamp clockintime;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "clock_off_time")
    private Timestamp clockofftime;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @TableField(value = "clock_date")
    private Timestamp clockdate;
}
