package demo.service.impl;

import demo.dao.CorpDao;
import demo.model.CorpPO;
import demo.service.CorpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorpServiceImpl implements CorpService {
    @Autowired
    CorpDao corpDao;

    /**
     * 根据主键获取企业
     *
     * @param org
     * @param id
     * @param seqId
     * @return
     */
    @Override
    public CorpPO getCorpByKey(Integer org, Integer id, Integer seqId) {
        return corpDao.findByCorpKeyOrgAndCorpKeyIdAndCorpKeySeqId(org, id, seqId);
    }

    /**
     * 根据名字获取企业
     * @param name
     * @return
     */
    @Override
    public List<CorpPO> getCorpByName(String name) {
        return corpDao.findLikeCorpName("%"+name+"%");
    }

    @Override
    public List<CorpPO> getAllCorp(){
        return corpDao.findAll();
    }
}
