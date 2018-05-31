package demo.dao;

import demo.model.CorpKey;
import demo.model.CorpPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CorpDao extends JpaRepository<CorpPO,CorpKey> {
    CorpPO findByCorpKeyOrgAndCorpKeyIdAndCorpKeySeqId(Integer org,Integer id,Integer seqId);

    @Query(value = "select c from CorpPO c where c.corpName like ?1 escape '/'")
    List<CorpPO> findLikeCorpName(String name);


//    @Query(value = "select c from CorpPO c where c.regNo = ?1 ")
    CorpPO findByCorpName(String name);

    @Query(value = "select c from CorpPO c")
    List<CorpPO> findAll();
}
