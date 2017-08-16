package com.user.service.impl;

import com.user.mapper.TDemoMapper;
import com.user.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by t on 2017/8/16.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TDemoMapper tDemoMapper;

    public List queryList() {
//        tDemoMapper = (TDemoMapper) new ClassPathXmlApplicationContext("classpath:applicationContext.xml")
//                .getBean(TDemoMapper.class);

        return tDemoMapper.getUser();

    }
}
