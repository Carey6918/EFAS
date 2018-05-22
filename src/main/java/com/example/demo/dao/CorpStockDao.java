package com.example.demo.dao;

import com.example.demo.model.CorpKey;
import com.example.demo.model.CorpStockPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CorpStockDao extends JpaRepository<CorpStockPO,CorpKey> {
    @Query(value = "select b from CorpStockPO b where b.price>?1 and b.price<?2")
    List<CorpStockPO> findByCorp(int org,int id,int seqId);
}
