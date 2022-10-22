package com.framework.manger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/hello")
@Slf4j
@Api(tags = "hello")
public class HelloController {

    @GetMapping
    @ApiOperation("hello")
    public HelloVO hello(){
//        return """
//                {"income":"3.87%","outset":"0.01","tip":"专属理财  即将结束"}
//                """;

        return HelloVO.builder().name("happy")
                .context("hello world")
                .createTime(new Date())
                .build();
    }
}
