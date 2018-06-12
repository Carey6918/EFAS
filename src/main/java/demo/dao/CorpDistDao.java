package demo.dao;

import demo.model.CorpDistPO;
import demo.model.CorpKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CorpDistDao extends JpaRepository<CorpDistPO, CorpKey> {
    @Query(value = "select s from CorpDistPO s, TMCorpCorpDistPO m where m.org=?1 and m.id=?2 and m.seqId=?3 and s.corpKey.org=m.subOrg and s.corpKey.id = m.subId and s.corpKey.seqId=m.subSeqId")
    List<CorpDistPO> findByCorp(int org, int id, int seqId);

    List<CorpDistPO> findByDistName(String name);
}
