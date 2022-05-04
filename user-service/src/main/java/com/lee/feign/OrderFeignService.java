package com.lee.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Fox
 */
@FeignClient(value = "service-order", path = "/")
public interface OrderFeignService {

    @RequestMapping("/queryOrderById")
    public Object queryOrderById();
}
