package com.huangyuan.work.entity;

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
public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String number;

    private String username;

    private String password;

    private String sex;

    private String phone;

    private Integer role;

    private Integer remark;


}
