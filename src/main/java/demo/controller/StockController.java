package demo.controller;

import demo.model.CorpPO;
import demo.model.InnerStockVO;
import demo.model.OuterStockVO;
import demo.service.CorpService;
import demo.service.CorpStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {
    @Autowired
    CorpStockService corpStockService;
    @Autowired
    CorpService corpService;

    /**
     * 返回股东族谱
     *
     * @param org
     * @param id
     * @param seqId
     * @return
     */
    @RequestMapping("/inner")
    public InnerStockVO getInnerStock(int org, int id, int seqId) {
        return corpStockService.getInnerStock(org, id, seqId);
    }

    /**
     * 返回对外投资族谱
     *
     * @param org
     * @param id
     * @param seqId
     * @return
     */
    @RequestMapping("/outer")
    public OuterStockVO getOuterStock(int org, int id, int seqId) {
        return corpStockService.getOuterStock(org, id, seqId);
    }

    /**
     * 更新股票百分比
     */
    @RequestMapping("/update")
    public void update() {
        List<CorpPO> corpPOList = corpService.getAllCorp();
        for (CorpPO corpPO : corpPOList) {
            corpStockService.countPercent(corpPO.getCorpKey().getOrg(), corpPO.getCorpKey().getId(), corpPO.getCorpKey().getSeqId());
        }
    }
}
