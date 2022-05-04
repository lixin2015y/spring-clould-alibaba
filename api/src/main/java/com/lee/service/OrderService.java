package com.lee.service;

import java.util.List;

public interface OrderService {
    List<String> queryAllOrderByUserId(String useId);
}
