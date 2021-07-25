package com.turong.profile.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.turong.profile.mapper")
public class MybatisConfig {

}
