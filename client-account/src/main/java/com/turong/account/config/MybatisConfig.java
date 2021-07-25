package com.turong.account.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.turong.account.mapper")
public class MybatisConfig {

}
