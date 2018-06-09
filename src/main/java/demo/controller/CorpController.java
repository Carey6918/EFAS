package demo.controller;


import demo.model.AtlasVO;
import demo.model.CorpPO;
import demo.model.CorpStockVO;
import demo.service.CorpService;
import demo.service.CorpStockService;
import demo.util.ResultBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class CorpController {
    @Autowired
    CorpService corpService;
    @Autowired
    CorpStockService corpStockService;

    /**
     * 根据主键返回一个公司的具体信息
     *
     * @param org
     * @param id
     * @param seqId
     * @return
     */
    @RequestMapping("/info")
    public ResultBundle<CorpPO> index(int org, int id, int seqId) {
        CorpPO po = corpService.getCorpByKey(org, id, seqId);
        if (po != null)
            return new ResultBundle(po);
        else
            return new ResultBundle(false, "没有这个企业");
    }

    /**
     * 返回某个企业的股权结构（最大股东，企业股东，自然人股东）
     *
     * @param org
     * @param id
     * @param seqId
     * @return
     */
    @RequestMapping("/stock")
    public ResultBundle<List<CorpStockVO>> stock(int org, int id, int seqId) {
        List<CorpStockVO> corpStockVOList = corpStockService.getStockStructure(org, id, seqId);
        if (!corpStockVOList.isEmpty())
            return new ResultBundle(corpStockVOList);
        else
            return new ResultBundle(false, "这个企业没有股东");
    }

    /**
     * 根据关键词搜索名字返回企业列表
     *
     * @param name
     * @return
     */
    @RequestMapping("/search")
    public ResultBundle<List<CorpPO>> searchByName(String name) {
        List<CorpPO> corpPOList = corpService.getCorpByName(name);
        if (!corpPOList.isEmpty())
            return new ResultBundle(corpPOList);
        else
            return new ResultBundle(false, "没有相关企业");
    }

    /**
     * 返回某个企业的图谱
     *
     * @param org
     * @param id
     * @param seqId
     * @return
     */
    @RequestMapping("/atlas")
    public ResultBundle<AtlasVO> getAtlas(int org, int id, int seqId) {
        return new ResultBundle(corpService.getAtlas(org, id, seqId));
    }
}
