package com.example.service.impl;

import com.example.annotation.CommonLogHandler;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public void getUserName() {
        logger.info("用户姓名为：弗拉基米尔·弗拉基米罗维奇·普京");
    }

    @CommonLogHandler
    public void updateUser(String userName) {
        logger.info("{} 更新成功！", userName);
    }

    public String listUser() {
        return "弗拉基米尔·弗拉基米罗维奇·普京 | 奥萨马·本·穆罕默德·本·阿瓦德·本·拉登";
    }

}
