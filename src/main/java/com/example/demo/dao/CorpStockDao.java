package com.example.demo.dao;

import com.example.demo.model.CorpKey;
import com.example.demo.model.CorpStockPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CorpStockDao extends JpaRepository<CorpStockPO,CorpKey> {
    @Query(value = "select s from CorpStockPO s  join (select m from TMCorpCorpStockPO m where m.org=? and m.id=? and m.seqId=?) t on s.corpKey.org=t.subOrg and s.corpKey.id = t.id and s.corpKey.seqId=t.seqId")
    List<CorpStockPO> findByCorp(int org,int id,int seqId);
}
