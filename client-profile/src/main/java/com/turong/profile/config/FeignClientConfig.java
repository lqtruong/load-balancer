package com.turong.profile.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@EnableFeignClients(basePackages = "com.turong.profile.feign")
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class FeignClientConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                requestTemplate.header(TenantHeaderFilter.X_TENANT_ID, AppContextHolder.getTenant());
            }
        };
    }

}
