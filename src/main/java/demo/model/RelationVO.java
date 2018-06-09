package demo.model;

import java.util.List;

public class RelationVO {
    private List<RelationNodeVO> nodeList;
    private List<RelationLinkVO> linkList;

    public RelationVO(List<RelationNodeVO> nodeList, List<RelationLinkVO> linkList) {
        this.nodeList = nodeList;
        this.linkList = linkList;
    }

    public List<RelationNodeVO> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<RelationNodeVO> nodeList) {
        this.nodeList = nodeList;
    }

    public List<RelationLinkVO> getLinkList() {
        return linkList;
    }

    public void setLinkList(List<RelationLinkVO> linkList) {
        this.linkList = linkList;
    }
}
