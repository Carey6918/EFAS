package demo.service.impl;

import demo.dao.CorpDao;
import demo.dao.CorpPertainsDao;
import demo.dao.CorpStockDao;
import demo.model.*;
import demo.service.CorpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
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
     *
     * @param name
     * @return
     */
    @Override
    public List<CorpPO> getCorpByName(String name) {
        return corpDao.findLikeCorpName("%" + name + "%");
    }

    @Override
    public List<CorpPO> getAllCorp() {
        return corpDao.findAll();
    }

    /**
     * 获取企业信息图谱
     *
     * @param org
     * @param id
     * @param seqId
     * @return
     */
    @Override
    public AtlasVO getAtlas(Integer org, Integer id, Integer seqId) {
        CorpPO po = corpDao.findByCorpKeyOrgAndCorpKeyIdAndCorpKeySeqId(org, id, seqId);
        AtlasVO root = new AtlasVO(po.getCorpName());
        AtlasVO outerStock = new AtlasVO("对外投资");
        List<CorpStockPO> corpStockPOList = corpStockDao.findByStockName(root.getName());
        for (CorpStockPO corpStockPO : corpStockPOList) {
            CorpPO corpPO = corpDao.findByStock(corpStockPO.getCorpKey().getOrg(), corpStockPO.getCorpKey().getId(), corpStockPO.getCorpKey().getSeqId());
            if (corpPO != null) {
                AtlasVO vo = new AtlasVO(corpPO.getCorpName());
                outerStock.addChildren(vo);
            }
        }
        root.addChildren(outerStock);
        AtlasVO innerStock = new AtlasVO("股东");
        corpStockPOList = corpStockDao.findByCorp(org, id, seqId);
        for (CorpStockPO corpStockPO : corpStockPOList) {
            AtlasVO vo = new AtlasVO(corpStockPO.getStockName());
            innerStock.addChildren(vo);
        }
        root.addChildren(innerStock);
        AtlasVO pertains = new AtlasVO("高管");
        List<CorpPertainsPO> corpPertainsPOList = corpPertainsDao.findByCorp(org, id, seqId);
        for (CorpPertainsPO corpPertainsPO : corpPertainsPOList) {
            AtlasVO vo = new AtlasVO(corpPertainsPO.getPersonName());
            pertains.addChildren(vo);
        }
        root.addChildren(pertains);
        return root;
    }

    @Override
    public RelationVO getRelation(Integer org, Integer id, Integer seqId) {
        CorpPO corpPO = corpDao.findByCorpKeyOrgAndCorpKeyIdAndCorpKeySeqId(org, id, seqId);
        RelationNodeVO root = new RelationNodeVO(0, corpPO.getCorpName());
        List<RelationNodeVO> nodeList = new LinkedList<>();
        nodeList.add(root);
        List<RelationLinkVO> linkList = new LinkedList<>();
        reverseRelation(root,nodeList,linkList);
        RelationVO relationVO = new RelationVO(nodeList,linkList);
        return relationVO;
    }



    public void reverseRelation(RelationNodeVO node, List<RelationNodeVO> nodeList, List<RelationLinkVO> linkList) {
        List<RelationNodeVO> addNode = new LinkedList<>();
        if (node.getCategory() == 0 || node.getCategory() == 1) {//公司
            List<RelationNodeVO> tempNodeList = new LinkedList<>();
            List<RelationLinkVO> tempLinkList = new LinkedList<>();
            searchFromCorpRelation(node.getName(),tempNodeList,tempLinkList);
            searchToCorpRelation(node.getName(),tempNodeList,tempLinkList);
            // 检查是否有重复节点和边，如果没有，则列入结果集。
            for (RelationNodeVO nodeVO:tempNodeList){
                if (!nodeList.contains(nodeVO)){
                    nodeList.add(nodeVO);
                    addNode.add(nodeVO);
                }
            }
            for (RelationLinkVO linkVO:tempLinkList){
                if (!linkList.contains(linkVO)){
                    linkList.add(linkVO);
                }
            }
        } else if (node.getCategory() == 2) {//自然人

        }
        for (RelationNodeVO nodeVO:addNode){
            reverseRelation(nodeVO,nodeList,linkList);
        }
    }

    public void searchFromCorpRelation(String name, List<RelationNodeVO> nodeList, List<RelationLinkVO> linkList) {
        // 法人
        CorpPO corpPO = corpDao.findByCorpName(name);
        RelationNodeVO tempNode;
        RelationLinkVO tempLink;
        if (corpPO == null) {
            return;
        }
            tempNode = new RelationNodeVO(2, corpPO.getOperManName());
            tempLink = new RelationLinkVO(name, corpPO.getOperManName(), "法人");
            nodeList.add(tempNode);
            linkList.add(tempLink);


        // 高管
        CorpKey corpKey = corpPO.getCorpKey();
        List<CorpPertainsPO> corpPertainsPOList = corpPertainsDao.findByCorp(corpKey.getOrg(), corpKey.getId(), corpKey.getSeqId());
        for (CorpPertainsPO corpPertainsPO : corpPertainsPOList) {
            tempNode = new RelationNodeVO(2, corpPertainsPO.getPersonName());
            tempLink = new RelationLinkVO(name, corpPertainsPO.getPersonName(), corpPertainsPO.getPersonType());
            nodeList.add(tempNode);
            linkList.add(tempLink);
        }

        // 股东
        List<CorpStockPO> corpStockPOList = corpStockDao.findByCorp(corpKey.getOrg(), corpKey.getId(), corpKey.getSeqId());
        for (CorpStockPO corpStockPO : corpStockPOList) {
            if (corpStockPO.getStockType().equals("企业")) {
                tempNode = new RelationNodeVO(1, corpStockPO.getStockName());
            } else {
                tempNode = new RelationNodeVO(2, corpStockPO.getStockName());
            }
            tempLink = new RelationLinkVO(name, corpStockPO.getStockName(), "股东");
            nodeList.add(tempNode);
            linkList.add(tempLink);
        }

        // 分支机构
        // TODO
    }

    public void searchToCorpRelation(String name, List<RelationNodeVO> nodeList, List<RelationLinkVO> linkList) {
        // 作为别人的股东（对外投资）
        List<CorpStockPO> corpStockPOList = corpStockDao.findByStockName(name);
        RelationNodeVO tempNode;
        RelationLinkVO tempLink;
        for (CorpStockPO corpStockPO : corpStockPOList) {
            CorpPO corpPO = corpDao.findByStock(corpStockPO.getCorpKey().getOrg(), corpStockPO.getCorpKey().getId(), corpStockPO.getCorpKey().getSeqId());
            if (corpPO != null) {
                tempNode = new RelationNodeVO(1, corpPO.getCorpName());
                tempLink = new RelationLinkVO(corpPO.getCorpName(), name, "股东");
                nodeList.add(tempNode);
                linkList.add(tempLink);
            }
        }

        // 作为别人的分支机构（父机构）

    }
}
