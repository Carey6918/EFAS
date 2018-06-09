package demo.model;

import java.util.LinkedList;
import java.util.List;

/**
 * 企业图谱
 */
public class AtlasVO {
    private String name;
    private List<AtlasVO> children;

    public AtlasVO(String name){
        this.name=name;
        children = new LinkedList<>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<AtlasVO> getChildren() {
        return children;
    }

    public void setChildren(List<AtlasVO> children) {
        this.children = children;
    }

    public void addChildren(AtlasVO atlasVO) {
        this.children.add(atlasVO);
    }
}
