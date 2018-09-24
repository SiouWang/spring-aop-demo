package com.example;

import com.example.service.Student;
import com.example.service.ZhangSan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopApplication {

    public static void main(String [] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.example.*");
//        UserService us = context.getBean(UserService.class);
//        User user = us.getUser();
//        System.out.println(user.getUserName())
        Student zs = (Student) context.getBean("zhangSan");
        zs.sayHello();
    }
}
