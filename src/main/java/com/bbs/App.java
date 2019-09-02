package com.bbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zlb
 *
 */
@SpringBootApplication(scanBasePackages = "com.bbs",exclude = {DataSourceAutoConfiguration.class})
@EnableAutoConfiguration
@MapperScan("com.bbs.mapper")
@EnableSwagger2
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }
}
