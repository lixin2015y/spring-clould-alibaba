package com.lee;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

// 以RoutePredicateFactory结尾的，name名字就是CheckAuth
@Component
public class CheckAuthRoutePredicateFactory extends AbstractRoutePredicateFactory<CheckAuthRoutePredicateFactory.Config> {


    public CheckAuthRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return (GatewayPredicate) serverWebExchange -> {
            if (config.getName().equals("zhangsan")) {
                return true;
            }
            return false;
        };
    }


    @Override
    public String name() {
        return "CheckAuth";
    }

    @Override
    public List<String> shortcutFieldOrder() {
        // 这里是快捷配置的key，一一对应Config对象里面的参数
        return Arrays.asList("name");
    }

    public static class Config {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
