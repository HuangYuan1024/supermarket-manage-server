package com.huangyuan.information.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huangyuan.information.entity.ClockInfo;
import com.huangyuan.information.service.IClockInfoService;
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
@RequestMapping("/information/clock-info")
public class ClockInfoController {

    @Autowired
    IClockInfoService clockInfoService;

    ObjectMapper json = new ObjectMapper();
    HashMap result = new HashMap();

    @RequestMapping("/add")
    public String add(ClockInfo clockInfo) {
        result.clear();
        System.out.println("clockofftime:" + clockInfo.getClockofftime());
        clockInfo.setClockofftime(null);
        System.out.println("clockofftime:" + clockInfo.getClockofftime());
        if (clockInfoService.save(clockInfo)) {
            result.put("code", 200);
            result.put("message", "添加成功");
        } else {
            result.put("code", 400);
            result.put("message", "添加失败");
        }
        try {
            return json.writeValueAsString(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/update")
    public String update(ClockInfo clockInfo) {
        System.out.println("clockofftime:" + clockInfo.getClockofftime());
        if (clockInfo.getClockofftime() == null || clockInfo.getClockofftime().equals("") || clockInfo.getClockofftime().equals("null")) {
            clockInfo.setClockofftime(null);
        }
        System.out.println("clockofftime:" + clockInfo.getClockofftime());
        result.clear();
        if (clockInfoService.updateById(clockInfo)) {
            result.put("code", 200);
            result.put("message", "修改成功");
        } else {
            result.put("code", 400);
            result.put("message", "修改失败");
        }
        try {
            return json.writeValueAsString(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        result.clear();
        if (clockInfoService.removeById(id)) {
            result.put("code", 200);
            result.put("message", "删除成功");
        } else {
            result.put("code", 400);
            result.put("message", "删除失败");
        }
        try {
            return json.writeValueAsString(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/getByNumber")
    public String getByNumber(Integer id) {
        result.clear();
        ClockInfo clockInfo = clockInfoService.getById(id);
        if (clockInfo != null) {
            result.put("code", 200);
            result.put("message", "查询成功");
            result.put("data", clockInfo);
        } else {
            result.put("code", 400);
            result.put("message", "查询失败");
        }
        try {
            return json.writeValueAsString(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/list")
    public String list() {
        result.clear();
        List<ClockInfo> list = clockInfoService.list();
        result.put("code", 200);
        result.put("message", "查询成功");
        result.put("data", list);
        try {
            return json.writeValueAsString(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/count")
    public String count() {
        result.clear();
        Long count = clockInfoService.count();
        result.put("code", 200);
        result.put("message", "查询成功");
        result.put("data", count);
        try {
            return json.writeValueAsString(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/getByPage")
    public String getByPage(int pageNum, int pageSize, String number, String date) {
        result.clear();
        System.out.println("number:" + number + "date:" + date);
        QueryWrapper<ClockInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(number != null, "employee_no", number)
                        .like(date != null, "clock_date", date);
        Page<ClockInfo> p = new Page<>(pageNum, pageSize);
        IPage<ClockInfo> clockInfoPage = clockInfoService.page(p, queryWrapper);
        result.put("code", 200);
        result.put("message", "查询成功");
        result.put("data", clockInfoPage);
        try {
            return json.writeValueAsString(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
