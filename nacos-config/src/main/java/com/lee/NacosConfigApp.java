package com.lee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class NacosConfigApp {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext run = SpringApplication.run(NacosConfigApp.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        while (true) {
            System.out.println(environment.getProperty("name"));
            System.out.println(environment.getProperty("age"));
            TimeUnit.SECONDS.sleep(3);
        }
    }
}
