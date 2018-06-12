package demo.dao;

import demo.model.CorpKey;
import demo.model.CorpPertainsPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CorpPertainsDao extends JpaRepository<CorpPertainsPO, CorpKey> {

    @Query(value = "select s from CorpPO s, TMCorpCorpPertainsPO m where m.org=?1 and m.id=?2 and m.seqId=?3 and s.corpKey.org=m.subOrg and s.corpKey.id = m.subId and s.corpKey.seqId=m.subSeqId")
    List<CorpPertainsPO> findByCorp(int org,int id,int seqId);

    List<CorpPertainsPO> findByPersonName(String name);
}
