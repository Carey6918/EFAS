package com.example.demo.dao;

import com.example.demo.model.CorpKey;
import com.example.demo.model.CorpPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CorpDao extends JpaRepository<CorpPO,CorpKey> {
    CorpPO findByCorpKeyOrgAndCorpKeyIdAndCorpKeySeqId(Integer org,Integer id,Integer seqId);
    List<CorpPO> findByCorpName(String name);
}