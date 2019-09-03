package com.bbs.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


/**
 *
 * @author Administrator
 * @time 2019/3/1 11:21
 * @description
 */
@Configuration
@MapperScan("com.bbs.mapper*")
public class MybatisPlusConfig {


    /**
     * 逻辑删除Bean
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    /**
     *   mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }
    /***
     * plus 的性能优化
     * @return
     */
    @Bean
    @Profile({"dev","test"})
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        /*<!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 -->*/
        performanceInterceptor.setMaxTime(2000);
        /*<!--SQL是否格式化 默认false-->*/
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }

}
