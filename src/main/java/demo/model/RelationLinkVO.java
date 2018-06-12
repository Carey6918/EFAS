package demo.model;

/**
 * 疑似关系的连线
 */
public class RelationLinkVO {
    private String source;
    private String target;
    private String name;

    public RelationLinkVO(String source, String target, String name) {
        this.source = source;
        this.target = target;
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        return this.source.equals(((RelationLinkVO) o).source)&&
                this.target.equals(((RelationLinkVO) o).target)&&
                this.name.equals(((RelationLinkVO) o).name);
    }

}
