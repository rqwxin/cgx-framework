package com.framework.manger;


import cgx.framework.common.swagger.EnableSwagger;
import cgx.framework.common.web.config.EnableWeb;
import cgx.framework.common.web.config.WebConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableSwagger
@EnableWeb
@EnableAsync
@Slf4j
public class ManagerApplication {
    public static void main(String[] args) {
        log.info("manager 后台开始启动");
        SpringApplication.run(ManagerApplication.class);
        log.info("manager 后台启动完成");
    }
}
