package com.example.demo.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CorpStockServiceImplTest {

    @Autowired
    CorpStockServiceImpl corpStockService;
    @Test
    public void countPercent() {
        corpStockService.countPercent(876,120000,99);
    }
}