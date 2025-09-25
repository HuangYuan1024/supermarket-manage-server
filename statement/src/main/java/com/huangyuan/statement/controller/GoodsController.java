package com.huangyuan.statement.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huangyuan.statement.entity.Goods;
import com.huangyuan.statement.service.IGoodsService;
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
@RequestMapping("/work/goods")
public class GoodsController {

    @Autowired
    IGoodsService goodsService;

    ObjectMapper json = new ObjectMapper();
    HashMap<String, Object> result = new HashMap<>();

    @RequestMapping("/add")
    public String add(Goods goods) {
        result.clear();
        if (goodsService.save(goods)) {
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

    @RequestMapping("/list")
    public String list() {
        List<Goods> list = goodsService.list();
        result.put("code", 200);
        result.put("message", "查询成功");
        result.put("data", list);
        try {
            return json.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/getByNumber")
    public String getByNumber(String number) {
        Goods goods = goodsService.getById(number);
        result.clear();
        if (goods != null) {
            result.put("code", 200);
            result.put("message", "查询成功");
            result.put("data", goods);
        } else {
            result.put("code", 400);
            result.put("message", "商品不存在");
        }
        try {
            return json.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/getByName")
    public String getByName(String name) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("c_name", name);
        Goods goods = goodsService.getOne(queryWrapper);
        result.clear();
        if (goods != null) {
            result.put("code", 200);
            result.put("message", "查询成功");
            result.put("data", goods);
        } else {
            result.put("code", 400);
            result.put("message", "商品不存在");
        }
        try {
            return json.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/update")
    public String update(Goods goods) {
        result.clear();
        if (goodsService.updateById(goods)) {
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
        if (goodsService.removeById(number)) {
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

    @RequestMapping("/deleteByName")
    public String deleteByName(String name) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("c_name", name);
        result.clear();
        if (goodsService.remove(queryWrapper)) {
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
}
