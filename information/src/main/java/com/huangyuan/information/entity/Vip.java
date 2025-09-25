package com.huangyuan.information.entity;

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
@TableName("vip")
public class Vip implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "v_number")
    private String vnumber;

    @TableField(value = "v_name")
    private String vname;

    @TableField(value = "v_score")
    private Integer vscore;

    @TableField(value = "v_phone")
    private String vphone;

    @TableField(value = "v_date")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Timestamp vdate;


}
