package com.example.dao.impl;

import com.example.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    public void saveUser(String userName) {
        logger.info("用户：{} 保存成功！", userName);
    }
}
