package com.huangyuan.sale.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huangyuan.sale.entity.SellInfo;
import com.huangyuan.sale.service.IGoodsService;
import com.huangyuan.sale.service.ISellInfoService;
import com.huangyuan.sale.service.IVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
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
@RequestMapping("/sale/sell-info")
public class SellInfoController {

    @Autowired
    ISellInfoService sellInfoService;

    @Autowired
    IGoodsService goodService;

    @Autowired
    IVipService vipService;

    ObjectMapper json = new ObjectMapper();
    HashMap<String, Object> result = new HashMap<>();

    /** 结账：扣库存 + 写销售记录 + 会员积分 */
    @Transactional
    @RequestMapping("/checkout")
    public String checkout(Integer skuid,
                           Integer qty,
                           String empno,
                           @RequestParam(required = false) String vipno){
        if (skuid == null || qty == null || empno == null) {
            result.put("code", 400);
            result.put("message", "参数不能为空:" + "skuid:" + skuid + " ,qty:" + qty + " ,empno:" + empno);
            try {
                return json.writeValueAsString(result);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        if (vipno.trim().isEmpty() || vipno.equals("null")) {
            vipno = null;
        }

        result.clear();
        // 1. 库存检查
        int inv = goodService.getInventory(skuid);
        if(inv < qty){
            result.put("code", 400);
            result.put("message", "库存不足");
            try {
                return json.writeValueAsString(result);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        // 2. 扣库存
        goodService.deductInventory(skuid, qty);

        // 3. 写销售记录
        sellInfoService.insertSellRecord(skuid, qty, LocalDate.now(), empno, vipno);

        // 4. 会员积分：1 元 = 1 分
        if(vipno != null){
            BigDecimal pay = goodService.selectPrice(skuid).multiply(BigDecimal.valueOf(qty));
            vipService.addScore(vipno, pay.intValue());
        }

        result.put("code", 200);
        result.put("message", "结账成功");
        try {
            return json.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

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
        } catch (JsonProcessingException e) {
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
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/deleteByNumber")
    public String deleteByNumber(String number) {
        result.clear();
        if (sellInfoService.removeById(number)) {
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
        SellInfo sellInfo = sellInfoService.getById(number);
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
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/getByEmployeeNumber")
    public String getByEmployeeNumber(String number) {
        result.clear();
        QueryWrapper<SellInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("s_e_number", number);
        List<SellInfo> sellInfoList = sellInfoService.list(queryWrapper);
        if (sellInfoList != null) {
            result.put("code", 200);
            result.put("data", sellInfoList);
            result.put("message", "查询成功");
        } else {
            result.put("code", 400);
            result.put("message", "没有此员工销售信息");
        }
        try {
            return json.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/getByVipNumber")
    public String getByVipNumber(String number) {
        result.clear();
        QueryWrapper<SellInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("s_vip_number", number);
        List<SellInfo> list = sellInfoService.list(queryWrapper);
        if (list != null) {
            result.put("code", 200);
            result.put("data", list);
            result.put("message", "查询成功");
        } else {
            result.put("code", 400);
            result.put("message", "没有此会员账单信息");
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
        List<SellInfo> list = sellInfoService.list();
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
