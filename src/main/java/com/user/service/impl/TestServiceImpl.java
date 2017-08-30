package com.user.service.impl;

import com.user.mapper.TDemoMapper;
import com.user.po.TDemo;
import com.user.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(propagation= Propagation.REQUIRED)
    public int insertTdemo(TDemo td) {
        int affect  = tDemoMapper.insertTdemo(td);

         int b =    affect/0;

        return affect;
    }
}
