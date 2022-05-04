package com.lee.controller;

import com.lee.feign.OrderFeignService;
import com.lee.service.OrderService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.checkerframework.common.reflection.qual.GetConstructor;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    RestTemplate restTemplate;

    @Resource
    OrderFeignService orderFeignService;

    @DubboReference
    OrderService orderService;


    @GetMapping("getUserOrder")
    Object getUserOrder() {
//        return restTemplate.getForObject("http://service-order/queryOrderById", Object.class);
        return orderFeignService.queryOrderById();
    }

    @GetMapping("getUserOrderById")
    Object getUserOrderById(String id) {
        return orderService.queryAllOrderByUserId(id);
    }
}
