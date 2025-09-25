package com.huangyuan.sale.service.impl;

import com.huangyuan.sale.entity.Employee;
import com.huangyuan.sale.mapper.EmployeeMapper;
import com.huangyuan.sale.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huangyuan
 * @since 2025-08-12
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
