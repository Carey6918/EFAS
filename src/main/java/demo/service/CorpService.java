package demo.service;

import demo.model.AtlasVO;
import demo.model.CorpPO;

import java.util.List;

public interface CorpService {

    CorpPO getCorpByKey(Integer org,Integer id,Integer seqId);
    List<CorpPO> getCorpByName(String name);

    List<CorpPO> getAllCorp();

    AtlasVO getAtlas(Integer org, Integer id, Integer seqId);
}
