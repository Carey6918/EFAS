package demo.service.impl;

import demo.dao.CorpDao;
import demo.dao.CorpStockDao;
import demo.model.*;
import demo.service.CorpStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

@Service
public class CorpStockServiceImpl implements CorpStockService {
    @Autowired
    CorpStockDao corpStockDao;
    @Autowired
    CorpDao corpDao;

    /**
     * 定期计算股权百分比
     *
     * @param org
     * @param id
     * @param seqId
     */
    @Override
    public void countPercent(Integer org, Integer id, Integer seqId) {
        List<CorpStockPO> corpStockPOList = corpStockDao.findByCorp(org, id, seqId);
        int sumCapi = 0;
        for (CorpStockPO po : corpStockPOList) {
            sumCapi += po.getStockCapi();
        }
        for (CorpStockPO po : corpStockPOList) {
            double percent = po.getStockCapi() / sumCapi * 100;
            DecimalFormat df = new DecimalFormat("#.00");
            String percentStr = df.format(percent);
            po.setStockPercent(percentStr + "%");
            corpStockDao.save(po);
        }
    }

    /**
     * 按入股从大到小的顺序返回企业的股东，第一为大股东
     *
     * @param org
     * @param id
     * @param seqId
     * @return
     */
    @Override
    public List<CorpStockVO> getStockStructure(Integer org, Integer id, Integer seqId) {
        List<CorpStockPO> corpStockPOList = corpStockDao.findByCorpAndSort(org, id, seqId);
        List<CorpStockVO> corpStockVOList = new LinkedList<>();
        if (!corpStockPOList.isEmpty()) {
            corpStockVOList.add(new CorpStockVO(corpStockPOList.get(0).getStockName(), corpStockPOList.get(0).getStockCapi(), corpStockPOList.get(0).getStockPercent(), "大股东"));
            for (int i = 1; i < corpStockPOList.size(); i++) {
                corpStockVOList.add(new CorpStockVO(corpStockPOList.get(i).getStockName(), corpStockPOList.get(i).getStockCapi(), corpStockPOList.get(i).getStockPercent(), corpStockPOList.get(i).getStockType()));
            }
        }
        return corpStockVOList;
    }

    /**
     * 获取某个公司的股东树关系
     *
     * @param org
     * @param id
     * @param seqId
     * @return
     */
    @Override
    public InnerStockVO getInnerStock(Integer org, Integer id, Integer seqId) {
        CorpPO corpPO = corpDao.findByCorpKeyOrgAndCorpKeyIdAndCorpKeySeqId(org, id, seqId);
        InnerStockVO root = new InnerStockVO(corpPO.getCorpName(), null);
        reverseInnerStock(root);
        return root;
    }

    /**
     * 根据递归实现股东树的连接
     *
     * @param innerStockVO
     */
    public void reverseInnerStock(InnerStockVO innerStockVO) {

        CorpPO corpPO = corpDao.findByCorpName(innerStockVO.getName());
        if (corpPO == null)
            return;
        CorpKey corpKey = corpPO.getCorpKey();
        List<CorpStockPO> corpStockPOList = corpStockDao.findByCorp(corpKey.getOrg(), corpKey.getId(), corpKey.getSeqId());
        if (corpStockPOList == null)
            return;
        for (CorpStockPO corpStockPO : corpStockPOList) {
            InnerStockVO vo = new InnerStockVO(corpStockPO.getStockName(), corpStockPO.getStockPercent());

            if (corpStockPO.getStockType().equals("企业")) {
                reverseInnerStock(vo);
            }
            innerStockVO.addChildren(vo);
        }
    }

    /**
     * 获取某个公司的对外投资关系
     *
     * @param org
     * @param id
     * @param seqId
     * @return
     */
    @Override
    public OuterStockVO getOuterStock(Integer org, Integer id, Integer seqId) {
        CorpPO corpPO = corpDao.findByCorpKeyOrgAndCorpKeyIdAndCorpKeySeqId(org, id, seqId);
        OuterStockVO root = new OuterStockVO(corpPO.getCorpName(), null);
        reverseOuterStock(root);
        return root;
    }

    public void reverseOuterStock(OuterStockVO outerStockVO) {
        List<CorpStockPO> corpStockPOList = corpStockDao.findByStockName(outerStockVO.getName());
        if (corpStockPOList == null)
            return;
        for (CorpStockPO corpStockPO : corpStockPOList) {
            CorpPO corpPO = corpDao.findByStock(corpStockPO.getCorpKey().getOrg(), corpStockPO.getCorpKey().getId(), corpStockPO.getCorpKey().getSeqId());
            if (corpPO != null) {
                OuterStockVO vo = new OuterStockVO(corpPO.getCorpName(), corpStockPO.getStockPercent());
                reverseOuterStock(vo);
                outerStockVO.addChildren(vo);
            }
        }
    }

}
