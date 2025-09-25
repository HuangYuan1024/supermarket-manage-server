package com.huangyuan.work.entity;

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
public class SellInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer sCNumber;

    private Integer sQuantity;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp sTime;

    private String sENumber;

    private String sVipNumber;


}
