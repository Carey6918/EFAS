package demo.controller;

import demo.model.CorpPO;
import demo.model.InnerStockVO;
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

    @RequestMapping("/inner")
    public InnerStockVO index(int org, int id, int seqId) {
        return corpStockService.getInnerStock(org, id, seqId);
    }

    @RequestMapping("/update")
    public void update(){
        List<CorpPO> corpPOList = corpService.getAllCorp();
        for(CorpPO corpPO :corpPOList){
            corpStockService.countPercent(corpPO.getCorpKey().getOrg(),corpPO.getCorpKey().getId(),corpPO.getCorpKey().getSeqId());
        }
    }
}
