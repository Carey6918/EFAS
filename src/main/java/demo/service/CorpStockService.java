package demo.service;

import demo.model.CorpStockVO;
import demo.model.InnerStockVO;
import demo.model.OuterStockVO;

import java.util.List;

public interface CorpStockService {

    void countPercent(Integer org, Integer id, Integer seqId);

    List<CorpStockVO> getStockStructure(Integer org, Integer id, Integer seqId);

    InnerStockVO getInnerStock(Integer org, Integer id, Integer seqId);

    OuterStockVO getOuterStock(Integer org, Integer id, Integer seqId);
}
