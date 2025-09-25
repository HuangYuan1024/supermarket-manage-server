package com.huangyuan.statement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("sell_info")
public class SellInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    // 商品编号
    @TableField(value = "s_c_number")
    private Integer cnumber;

    // 数量
    @TableField(value = "s_quantity")
    private Integer quantity;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "s_time")
    private Timestamp time;

    // 员工编号(收银员)
    @TableField(value = "s_e_number")
    private String enumber;

    // 会员编号
    @TableField(value = "s_vip_number")
    private String vnumber;

}
