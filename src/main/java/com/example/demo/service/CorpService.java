package com.example.demo.service;

import com.example.demo.model.CorpPO;

import java.util.List;

public interface CorpService {

    CorpPO getCorpByKey(Integer org,Integer id,Integer seqId);
    List<CorpPO> getCorpByName(String name);
}
