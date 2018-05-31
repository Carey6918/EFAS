package demo.model;

import java.util.LinkedList;
import java.util.List;

/**
 * 股东
 */
public class InnerStockVO {
    private String name;
    private String value;
    private List<InnerStockVO> children;

    public InnerStockVO(String name, String value) {
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

    public List<InnerStockVO> getChildren() {
        return children;
    }

    public void setChildren(List<InnerStockVO> children) {
        this.children = children;
    }

    public void addChildren(InnerStockVO innerStockVO) {
        this.children.add(innerStockVO);
    }
}