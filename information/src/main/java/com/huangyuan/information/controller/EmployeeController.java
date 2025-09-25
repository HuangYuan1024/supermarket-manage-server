package com.huangyuan.information.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huangyuan.information.entity.Employee;
import com.huangyuan.information.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huangyuan
 * @since 2025-08-12
 */
@RestController
@RequestMapping("/information/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    ObjectMapper json = new ObjectMapper();
    HashMap result = new HashMap();

    @RequestMapping("/login")
    public String login(String phone, String password) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phone);
        queryWrapper.eq("password", password);
        Employee employee = employeeService.getOne(queryWrapper);
        result.clear();
        if (employee != null) {
            result.put("code", 200);
            result.put("data", employee);
        } else {
            result.put("code", 400);
            result.put("message", "用户名或密码错误");
        }
        try {
            return json.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/register")
    public String register(Employee employee) {
        result.clear();
        if (employeeService.save(employee)) {
            result.put("code", 200);
            result.put("message", "注册成功");
        } else {
            result.put("code", 400);
            result.put("message", "注册失败");
        }
        try {
            return json.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/update")
    public String update(Employee employee) {
        result.clear();
        if (employeeService.updateById(employee)) {
            result.put("code", 200);
            result.put("message", "修改成功");
        } else {
            result.put("code", 400);
            result.put("message", "修改失败");
        }
        try {
            return json.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/delete")
    public String delete(String number) {
        result.clear();
        if (employeeService.removeById(number)) {
            result.put("code", 200);
            result.put("message", "删除成功");
        } else {
            result.put("code", 400);
            result.put("message", "删除失败");
        }
        try {
            return json.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/getByNumber")
    public String getByNumber(String number) {
        result.clear();
        Employee employee = employeeService.getById(number);
        if (employee != null) {
            result.put("code", 200);
            result.put("message", "查询成功");
            result.put("data", employee);
        } else {
            result.put("code", 400);
            result.put("message", "用户不存在");
        }
        try {
            return json.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/getByPhone")
    public String getByPhone(String phone) {
        result.clear();
        Employee employee = employeeService.getOne(new QueryWrapper<Employee>().eq("phone", phone));
        if (employee != null) {
            result.put("code", 200);
            result.put("message", "查询成功");
            result.put("data", employee);
        } else {
            result.put("code", 400);
            result.put("message", "用户不存在");
        }
        try {
            return json.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/list")
    public String list() {
        result.clear();
        List<Employee> list = employeeService.list();
        result.put("code", 200);
        result.put("message", "查询成功");
        result.put("data", list);
        try {
            return json.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/count")
    public String count() {
        result.clear();
        Long count = employeeService.count();
        result.put("code", 200);
        result.put("message", "查询成功");
        result.put("data", count);
        try {
            return json.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/getByPage")
    public String getByPage(int pageNum, int pageSize, String name, String number) {
        result.clear();
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(name != null, "username", name);
        queryWrapper.like(number != null, "number", number);
        // 第 pageNum 页，每页 pageSize 条
        Page<Employee> p = new Page<>(pageNum, pageSize);
        IPage<Employee> page = employeeService.page(p, queryWrapper);
        result.put("code", 200);
        result.put("message", "查询成功");
        result.put("data", page);
        try {
            return json.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
