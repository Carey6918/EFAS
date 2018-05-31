package demo.service;

import demo.model.CorpStockVO;
import demo.model.InnerStockVO;

import java.util.List;

public interface CorpStockService {

    void countPercent(Integer org, Integer id, Integer seqId);
    List<CorpStockVO> getStockStructure(Integer org, Integer id, Integer seqId);

    InnerStockVO getInnerStock(Integer org, Integer id, Integer seqId);
}
