package com.imooc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @Author: kb
 * @Date: 2020-08-30 20:56
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public Object hello(){
        return "hello";
    }
}
