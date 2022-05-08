package com.lee.controller;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class OrderController {


    @GetMapping("queryOrderById")
    Object queryOrderById(String id) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(1, "李新");
        return hashMap;
    }
}
