package com.huangyuan.sale.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class WorkDate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "work_date_id", type = IdType.AUTO)
    private Integer workDateId;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Timestamp workDate;


}
