package com.example.demo.controller;


import com.example.demo.model.CorpPO;
import com.example.demo.service.CorpService;
import com.example.demo.util.ResultBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class CorpController {
    @Autowired
    CorpService corpService;

    @RequestMapping("/info")
    public ResultBundle<CorpPO> index(int org, int id, int seqId) {
        CorpPO po = corpService.getCorpByKey(org, id, seqId);
        if (po != null)
            return new ResultBundle(po);
        else
            return new ResultBundle(false, "没有这个企业");
    }
}
