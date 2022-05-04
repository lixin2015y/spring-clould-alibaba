package com.lee.service;

import org.apache.dubbo.config.annotation.DubboService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@DubboService
public class OrderServiceImpl implements OrderService {

    @Override
    public List<String> queryAllOrderByUserId(String useId) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(UUID.randomUUID().toString());
        }
        return list;
    }
}
