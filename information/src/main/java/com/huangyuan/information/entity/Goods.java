package com.huangyuan.information.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

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
@TableName("goods")
public class Goods implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "c_number", type = IdType.AUTO)
    private Integer cNumber;

    private String cName;

    private BigDecimal cPrice;

    private BigDecimal vipPrice;

    private Integer inventory;


}
