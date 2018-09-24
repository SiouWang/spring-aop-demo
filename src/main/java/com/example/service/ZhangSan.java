package com.example.service;

import org.springframework.stereotype.Component;

@Component
public class ZhangSan implements Student {


    public void sayHello() {
        System.out.println("你好，我是张三...");
    }
}
