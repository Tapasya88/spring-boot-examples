package com.demo.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages={"com.demo.spring"})
@EnableAspectJAutoProxy
public class AppConfig {

}
