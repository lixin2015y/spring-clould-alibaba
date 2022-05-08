package com.lee;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class CheckAuthGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {
    @Override
    public String name() {
        return "CheckAuth";
    }

    @Override
    public GatewayFilter apply(NameValueConfig config) {
        return (exchange, chain) -> {
            System.out.println(("调用CheckAuthGatewayFilterFactory===" + config.getName() + ":" + config.getValue()));
            return chain.filter(exchange);
        };
    }
}
