package com.example.service;

import com.example.entity.User;
import com.example.annotation.MyAspectHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * 使用MyAspectHandler注解修饰，表示被aop切入
     * @return
     */
    @MyAspectHandler
    public User getUser() {
        User user = new User();
        user.setUserName("张三");
        logger.info("public User getUser()方法开始执行...");
        logger.info("开始执行1/0运算，即将抛出异常......");
//        int i = 1/0;
        return user;
    }
}
