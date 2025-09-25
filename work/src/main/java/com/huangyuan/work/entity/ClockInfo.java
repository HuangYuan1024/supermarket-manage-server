package com.huangyuan.work.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class ClockInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "clock_id", type = IdType.AUTO)
    private Integer clockId;

    private String employeeNo;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp clockInTime;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp clockOffTime;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Timestamp clockDate;


}
