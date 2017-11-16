package com.project.springboot_mybatis_druid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * spring boot app
 * @SpringBootApplication 代替@Configuration,@EnableAutoConfiguration,@ComponentScan
 * @ServletComponentScan 可以自定义servlet，否则无法访问webservlet，druid监控页面使用
 */
@SpringBootApplication
@ServletComponentScan
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
