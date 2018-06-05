package demo.model;

import java.util.LinkedList;
import java.util.List;

/**
 * 对外投资
 */
public class OuterStockVO {
    private String name;
    private String value;
    private List<OuterStockVO> children;

    public OuterStockVO(String name, String value) {
        this.name = name;
        this.value = value;
        this.children = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<OuterStockVO> getChildren() {
        return children;
    }

    public void setChildren(List<OuterStockVO> children) {
        this.children = children;
    }

    public void addChildren(OuterStockVO innerStockVO) {
        this.children.add(innerStockVO);
    }
}
