package demo.model;

/**
 * 疑似关系的节点
 */
public class RelationNodeVO {

    // 分类，0表示主体，1表示企业，2表示自然人
    private int category;
    private String name;

    public RelationNodeVO(int category, String name) {
        this.category = category;
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        return this.name.equals(((RelationNodeVO) o).name);
    }
}
