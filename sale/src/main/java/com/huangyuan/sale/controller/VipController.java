package com.huangyuan.sale.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huangyuan.sale.entity.Vip;
import com.huangyuan.sale.service.IVipService;
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
@RequestMapping("/sale/vip")
public class VipController {

    @Autowired
    IVipService vipService;

    ObjectMapper json = new ObjectMapper();
    HashMap<String, Object> result = new HashMap<>();

    @RequestMapping("/loginByNumber")
    public String loginByNumber(String number) {
        QueryWrapper<Vip> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("v_number", number);
        Vip vip = vipService.getOne(queryWrapper);
        result.clear();
        if (vip != null) {
            result.put("code", 200);
            result.put("data", vip);
        } else {
            result.put("code", 400);
            result.put("message", "会员不存在");
        }
        try {
            return json.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/loginByPhone")
    public String loginByPhone(String phone) {
        QueryWrapper<Vip> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("v_phone", phone);
        Vip vip = vipService.getOne(queryWrapper);
        result.clear();
        if (vip != null) {
            result.put("code", 200);
            result.put("data", vip);
        } else {
            result.put("code", 400);
            result.put("message", "会员不存在");
        }
        try {
            return json.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/register")
    public String register(Vip vip) {
        vip.setVdate(new java.sql.Timestamp(new java.util.Date().getTime()));
        result.clear();
        if (vipService.save(vip)) {
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
    public String update(Vip vip) {
        result.clear();
        if (vipService.updateById(vip)) {
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
        if (vipService.removeById(number)) {
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

    @RequestMapping("/deleteByPhone")
    public String deleteByPhone(String phone) {
        result.clear();
        QueryWrapper<Vip> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("v_phone", phone);
        if (vipService.remove(queryWrapper)) {
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
        Vip vip = vipService.getById(number);
        if (vip != null) {
            result.put("code", 200);
            result.put("message", "查询成功");
            result.put("data", vip);
        } else {
            result.put("code", 400);
            result.put("message", "会员不存在");
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
        Vip vip = vipService.getOne(new QueryWrapper<Vip>().eq("v_phone", phone));
        if (vip != null) {
            result.put("code", 200);
            result.put("message", "查询成功");
            result.put("data", vip);
        } else {
            result.put("code", 400);
            result.put("message", "会员不存在");
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
        List<Vip> list = vipService.list();
        result.put("code", 200);
        result.put("data", list);
        result.put("message", "查询成功");
        try {
            return json.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/count")
    public String count() {
        result.clear();
        Long count = vipService.count();
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
    public String getByPage(int pageNum, int pageSize, String name, String number, String phone) {
        result.clear();
        QueryWrapper<Vip> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(name != null, "v_name", name);
        queryWrapper.like(number != null, "v_number", number);
        queryWrapper.like(phone != null, "v_phone", phone);
        // 第 pageNum 页，每页 pageSize 条
        Page<Vip> page = new Page<>(pageNum, pageSize);
        IPage<Vip> vipPage = vipService.page(page, queryWrapper);
        result.put("code", 200);
        result.put("message", "查询成功");
        result.put("data", vipPage);
        try {
            return json.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
