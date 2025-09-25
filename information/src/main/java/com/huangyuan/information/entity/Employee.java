package com.huangyuan.information.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

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
@TableName("employee")
public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "number")
    private String number;

    private String username;

    private String password;

    private String sex;

    private String phone;

    private Integer role;

    private String remark;

}
