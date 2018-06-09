package demo.service.impl;

import demo.dao.CorpDao;
import demo.dao.CorpPertainsDao;
import demo.dao.CorpStockDao;
import demo.model.AtlasVO;
import demo.model.CorpPO;
import demo.model.CorpPertainsPO;
import demo.model.CorpStockPO;
import demo.service.CorpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorpServiceImpl implements CorpService {
    @Autowired
    CorpDao corpDao;
    @Autowired
    CorpStockDao corpStockDao;
    @Autowired
    CorpPertainsDao corpPertainsDao;

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

    /**
     * 获取企业信息图谱
     * @param org
     * @param id
     * @param seqId
     * @return
     */
    @Override
    public AtlasVO getAtlas(Integer org, Integer id, Integer seqId){
        CorpPO po = corpDao.findByCorpKeyOrgAndCorpKeyIdAndCorpKeySeqId(org,id,seqId);
        AtlasVO root = new AtlasVO(po.getCorpName());
        AtlasVO outerStock = new AtlasVO("对外投资");
        List<CorpStockPO> corpStockPOList = corpStockDao.findByStockName(root.getName());
        for (CorpStockPO corpStockPO:corpStockPOList){
            CorpPO corpPO = corpDao.findByStock(corpStockPO.getCorpKey().getOrg(), corpStockPO.getCorpKey().getId(), corpStockPO.getCorpKey().getSeqId());
            if (corpPO!=null) {
                AtlasVO vo = new AtlasVO(corpPO.getCorpName());
                outerStock.addChildren(vo);
            }
        }
        root.addChildren(outerStock);
        AtlasVO innerStock = new AtlasVO("股东");
        corpStockPOList = corpStockDao.findByCorp(org,id,seqId);
        for (CorpStockPO corpStockPO:corpStockPOList){
            AtlasVO vo = new AtlasVO(corpStockPO.getStockName());
            innerStock.addChildren(vo);
        }
        root.addChildren(innerStock);
        AtlasVO pertains = new AtlasVO("高管");
        List<CorpPertainsPO> corpPertainsPOList = corpPertainsDao.findByCorp(org,id,seqId);
        for (CorpPertainsPO corpPertainsPO:corpPertainsPOList){
            AtlasVO vo = new AtlasVO(corpPertainsPO.getPersonName());
            pertains.addChildren(vo);
        }
        root.addChildren(pertains);
        return root;
    }
}
