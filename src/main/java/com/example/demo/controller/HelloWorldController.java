package com.example.demo.controller;

import com.example.demo.model.CorpPO;
import com.example.demo.util.ResultBundle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloWorldController {
    @RequestMapping("/index")
    public ResultBundle<CorpPO> index(HttpServletRequest request, HttpServletResponse response) {
        CorpPO po = new CorpPO();
        ResultBundle<CorpPO> resultBundle = new ResultBundle(po);
        return resultBundle;
    }
}
