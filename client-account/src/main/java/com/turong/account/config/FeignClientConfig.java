package com.turong.account.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@EnableFeignClients(basePackages = "com.turong.account.feign")
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class FeignClientConfig {
}
