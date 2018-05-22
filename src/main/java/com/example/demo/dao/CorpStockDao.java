package com.example.demo.dao;

import com.example.demo.model.CorpKey;
import com.example.demo.model.CorpStockPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CorpStockDao extends JpaRepository<CorpStockPO,CorpKey> {
    @Query(value = "select s from CorpStockPO s, TMCorpCorpStockPO m where m.org=?1 and m.id=?2 and m.seqId=?3 and s.corpKey.org=m.subOrg and s.corpKey.id = m.subId and s.corpKey.seqId=m.subSeqId")
    List<CorpStockPO> findByCorp(int org,int id,int seqId);
    @Query(value = "select s from CorpStockPO s, TMCorpCorpStockPO m where m.org=?1 and m.id=?2 and m.seqId=?3 and s.corpKey.org=m.subOrg and s.corpKey.id = m.subId and s.corpKey.seqId=m.subSeqId order by s.stockCapi desc ")
    List<CorpStockPO> findByCorpAndSort(int org,int id,int seqId);

    CorpStockPO save(CorpStockPO po);
}
