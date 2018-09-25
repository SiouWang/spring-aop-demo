package com.example.aspect;

import com.example.config.ApplicationConfig;
import com.example.dao.UserDao;
import com.example.service.UserService;
import com.example.web.StudentWeb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class AspectUsingPointcutExampleTest {

    @Autowired
    StudentWeb studentWeb;

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    /**
     * 该测试用例模拟常规调用一个方法
     * 在切面类中，定义了一些Advice，它们结合自定义的切入点来自动切入方法执行一些动作
     *
     * 运行此方法可以测试com.example.pointcut.PointcutExample中定义的切入点
     * 在com.example.aspect.AspectUsingPointcutExample切面中的应用
     */
    @Test
    public void showAllStudentTest() {
        studentWeb.showAllStudent();
    }

    @Test
    public void getUserNameTest() {
        userService.getUserName();
    }

    @Test
    public void dataAccessOperationTest() {
        userDao.saveUser("奥萨马·本·穆罕默德·本·阿瓦德·本·拉登");
    }

    @Test
    public void updateUserTest() {
        userService.updateUser("贾瓦哈拉尔·尼赫鲁");
    }

    /**
     * 测试@AfterReturning通知
     */
    @Test
    public void listUserTest() {
        userService.listUser();
    }

}
