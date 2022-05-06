package com.lee.service;


import com.lee.entity.Order;
import com.lee.vo.OrderVo;

public interface OrderService {

    /**
     * 保存订单
     */
    Order saveOrder(OrderVo orderVo);
}
