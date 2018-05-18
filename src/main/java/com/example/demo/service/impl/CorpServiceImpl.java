package com.example.demo.service.impl;

import com.example.demo.dao.CorpDao;
import com.example.demo.model.CorpKey;
import com.example.demo.model.CorpPO;
import com.example.demo.service.CorpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorpServiceImpl implements CorpService {
    @Autowired
    CorpDao corpDao;

    @Override
    public CorpPO getCorpByKey(Integer org, Integer id, Integer seqId) {
        return corpDao.findByCorpKeyOrgAndCorpKeyIdAndCorpKeySeqId(org,id,seqId);
    }
}
