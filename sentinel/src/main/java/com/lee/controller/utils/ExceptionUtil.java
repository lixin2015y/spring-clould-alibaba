package com.lee.controller.utils;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lee.utils.R;


public class ExceptionUtil {

    public static R fallback(Integer id, Throwable e){
        return R.error(-2,"===被异常降级啦===");
    }

    public static R handleException(Integer id, BlockException e){
        return R.error(-2,"===被限流啦===");
    }
}
