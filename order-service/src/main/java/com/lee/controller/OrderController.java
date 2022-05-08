package com.lee.controller;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class OrderController {


    @GetMapping("queryOrderById")
    Object queryOrderById(String id, HttpServletRequest request) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(1, "李新");
        hashMap.put(2, request.getHeader("X-Request-color"));
        return hashMap;
    }
}
