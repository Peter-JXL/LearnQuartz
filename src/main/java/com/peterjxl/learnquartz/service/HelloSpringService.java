package com.peterjxl.learnquartz.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Service
public class HelloSpringService {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    public void init() {
        System.out.println("dataSource: " + dataSource);
    }

    public String  helloSpring() {
        return "Hello Spring";
    }
}
