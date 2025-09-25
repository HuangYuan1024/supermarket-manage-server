package com.huangyuan.information.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huangyuan.information.entity.Role;
import com.huangyuan.information.service.IRoleService;
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
@RequestMapping("/information/role")
public class RoleController {

    @Autowired
    IRoleService roleService;

    ObjectMapper json = new ObjectMapper();
    HashMap result = new HashMap();

    @RequestMapping("/add")
    public String add(Role role) {
        result.clear();
        if (roleService.save(role)) {
            result.put("code", 200);
            result.put("message", "添加成功");
        } else {
            result.put("code", 400);
            result.put("message", "添加失败");
        }
        try {
            return json.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/update")
    public String update(Role role) {
        result.clear();
        if (roleService.updateById(role)) {
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

    @RequestMapping("/deleteByNumber")
    public String deleteByNumber(String number) {
        result.clear();
        if (roleService.remove(new QueryWrapper<Role>().eq("id", number))) {
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
        Role role = roleService.getById(number);
        if (role != null) {
            result.put("code", 200);
            result.put("message", "查询成功");
            result.put("data", role);
        } else {
            result.put("code", 400);
            result.put("message", "角色不存在: " +  number);
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
        List<Role> list = roleService.list();
        result.put("code", 200);
        result.put("message", "查询成功");
        result.put("data", list);
        try {
            return json.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
