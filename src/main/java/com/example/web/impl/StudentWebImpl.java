package com.example.web.impl;

import com.example.web.StudentWeb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("studentWeb")
public class StudentWebImpl implements StudentWeb {

    private static final Logger logger = LoggerFactory.getLogger(StudentWebImpl.class);

    public void showAllStudent() {
        logger.info("所有学生名册为：张三、李四、王五、赵柳......");
    }
}
