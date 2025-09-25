package com.huangyuan.sale.controller;


import com.huangyuan.sale.service.IClockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huangyuan
 * @since 2025-08-12
 */
@RestController
@RequestMapping("/sale/clock-info")
public class ClockInfoController {

    @Autowired
    IClockInfoService clockInfoService;


}
