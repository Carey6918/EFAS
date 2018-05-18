package com.example.demo.service;

import com.example.demo.model.CorpPO;

public interface CorpService {

    CorpPO getCorpByKey(Integer org,Integer id,Integer seqId);
}
