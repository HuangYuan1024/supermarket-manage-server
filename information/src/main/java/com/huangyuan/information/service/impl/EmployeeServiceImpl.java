package com.huangyuan.information.service.impl;

import com.huangyuan.information.entity.Employee;
import com.huangyuan.information.mapper.EmployeeMapper;
import com.huangyuan.information.service.IEmployeeService;
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
