package com.huangyuan.statement.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huangyuan.statement.entity.SellInfo;
import com.huangyuan.statement.entity.dto.DayTurnoverDTO;
import com.huangyuan.statement.entity.dto.MonthTurnoverDTO;
import com.huangyuan.statement.entity.dto.WeekTurnoverDTO;
import com.huangyuan.statement.entity.dto.YearTurnoverDTO;
import com.huangyuan.statement.service.ISellInfoService;
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
 * @since 2025-08-13
 */
@RestController
@RequestMapping("/statement/sell-info")
public class SellInfoController {

    @Autowired
    ISellInfoService sellInfoService;

    ObjectMapper json = new ObjectMapper();
    HashMap result = new HashMap();

    @RequestMapping("/add")
    public String add(SellInfo sellInfo) {
        result.clear();
        if (sellInfoService.save(sellInfo)) {
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
    public String update(SellInfo sellInfo) {
        result.clear();
        if (sellInfoService.updateById(sellInfo)) {
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
        if (sellInfoService.removeById(id)) {
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
        SellInfo sellInfo = sellInfoService.getById(id);
        if (sellInfo != null) {
            result.put("code", 200);
            result.put("message", "查询成功");
            result.put("data", sellInfo);
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
        List<SellInfo> list = sellInfoService.list();
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
        Long count = sellInfoService.count();
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
    public String getByPage(int pageNum, int pageSize, String cnumber, String enumber) {
        result.clear();
        Page<SellInfo> p = new Page<>(pageNum, pageSize);
        QueryWrapper<SellInfo> queryWrapper = new QueryWrapper<>();
        // 按照商品编号查询
        queryWrapper.like(cnumber != null, "s_c_number", cnumber);
        // 按照员工编号查询
        queryWrapper.like(enumber != null, "s_e_number", enumber);
        IPage<SellInfo> page = sellInfoService.page(p, queryWrapper);
        result.put("code", 200);
        result.put("message", "查询成功");
        result.put("data", page);
        try {
            return json.writeValueAsString(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 每日营业额
    @RequestMapping("/turnoverEveryDay")
    public String turnoverEveryDay() {
        result.clear();
        List<DayTurnoverDTO> list = sellInfoService.turnoverEveryDay();
        result.put("code", 200);
        result.put("message", "查询成功");
        result.put("data", list);
        try {
            return json.writeValueAsString(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 每周营业额
    @RequestMapping("/turnoverEveryWeek")
    public String turnoverEveryWeek() {
        result.clear();
        List<WeekTurnoverDTO> list = sellInfoService.turnoverEveryWeek();
        result.put("code", 200);
        result.put("message", "查询成功");
        result.put("data", list);
        try {
            return json.writeValueAsString(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 每月营业额
    @RequestMapping("/turnoverEveryMonth")
    public String turnoverEveryMonth() {
        result.clear();
        List<MonthTurnoverDTO> list = sellInfoService.turnoverEveryMonth();
        result.put("code", 200);
        result.put("message", "查询成功");
        result.put("data", list);
        try {
            return json.writeValueAsString(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 每年营业额
    @RequestMapping("/turnoverEveryYear")
    public String turnoverEveryYear() {
        result.clear();
        List<YearTurnoverDTO> list = sellInfoService.turnoverEveryYear();
        result.put("code", 200);
        result.put("message", "查询成功");
        result.put("data", list);
        try {
            return json.writeValueAsString(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
