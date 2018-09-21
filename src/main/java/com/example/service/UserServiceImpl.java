package com.example.service;

import com.example.entity.User;
import com.example.annotation.MyAspectHandler;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    /**
     * 使用MyAspectHandler注解修饰，表示被aop切入
     * @return
     */
    @MyAspectHandler
    public User getUser() {
        User user = new User();
        user.setUserName("张三");
        return user;
    }
}
