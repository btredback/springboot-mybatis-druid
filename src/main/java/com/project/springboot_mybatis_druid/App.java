package com.project.springboot_mybatis_druid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * spring boot app
 * @SpringBootApplication 代替@Configuration,@EnableAutoConfiguration,@ComponentScan
 * @ServletComponentScan 可以自定义servlet，否则无法访问webservlet，druid监控页面使用
 */
@SpringBootApplication
@ServletComponentScan
public class App extends SpringBootServletInitializer {
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}

	public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
