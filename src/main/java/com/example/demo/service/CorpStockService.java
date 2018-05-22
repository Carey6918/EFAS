package com.example.demo.service;

import com.example.demo.model.CorpStockVO;

import java.util.List;

public interface CorpStockService {

    void countPercent(Integer org, Integer id, Integer seqId);
    List<CorpStockVO> getStockStructure(Integer org, Integer id, Integer seqId);
}
