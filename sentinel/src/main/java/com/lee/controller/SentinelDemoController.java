package com.lee.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import com.lee.controller.utils.ExceptionUtil;
import com.lee.utils.R;
import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SentinelDemoController {

    private final String RESOURCE_NAME = "resource";

    @GetMapping("test")
    Object test() {
        Entry entry = null;
        try {
            entry = SphU.entry(RESOURCE_NAME);
            return "正常返回";
        } catch (BlockException blockException) {
            return "限流了";
        } catch (Exception e) {
            Tracer.traceEntry(e, entry);
            return "业务异常了";
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
    }

    @PostConstruct
    private void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        //设置受保护的资源
        rule.setResource(RESOURCE_NAME);
        // 设置流控规则 QPS
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 设置受保护的资源阈值
        // Set limit QPS to 20.
        rule.setCount(1);
        rules.add(rule);
        // 加载配置好的规则
        FlowRuleManager.loadRules(rules);
    }

    @GetMapping("test1/{id}")
    @SentinelResource(value = "test", fallback = "fallback", fallbackClass = ExceptionUtil.class,
            blockHandler = "handleException", blockHandlerClass = ExceptionUtil.class)
    R test1(@PathVariable("id") Integer id) {
        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常");
        }
        return new R();
    }

}
