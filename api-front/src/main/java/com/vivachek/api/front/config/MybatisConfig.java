package com.vivachek.api.front.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/10 15:24
 */
@Configuration
public class MybatisConfig {
    /**
     * 注入分页插件，springBoot会将注入的插件自动设置到sqlSessionFactory中
     */
    @Bean
    public Interceptor interceptor(){
        return new PageInterceptor();
    }
}