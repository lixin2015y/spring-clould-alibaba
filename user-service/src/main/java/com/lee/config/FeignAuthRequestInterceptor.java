package com.lee.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.UUID;
public class FeignAuthRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("调用到拦截器。。。。。。。");
        requestTemplate.header("name", UUID.randomUUID().toString());
    }
}
