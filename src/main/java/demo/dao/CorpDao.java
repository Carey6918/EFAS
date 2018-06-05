package demo.dao;

import demo.model.CorpKey;
import demo.model.CorpPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CorpDao extends JpaRepository<CorpPO, CorpKey> {
    CorpPO findByCorpKeyOrgAndCorpKeyIdAndCorpKeySeqId(Integer org, Integer id, Integer seqId);

    @Query(value = "select c from CorpPO c where c.corpName like ?1 escape '/'")
    List<CorpPO> findLikeCorpName(String name);


    CorpPO findByCorpName(String name);

    @Query(value = "select c from CorpPO c")
    List<CorpPO> findAll();

    @Query(value = "select s from CorpPO s, TMCorpCorpStockPO m where m.subOrg=?1 and m.subId=?2 and m.subSeqId=?3 and s.corpKey.org=m.org and s.corpKey.id = m.id and s.corpKey.seqId=m.seqId")
    CorpPO findByStock(int org, int id, int seqId);
}
