package demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_m_corp_corp_stock", schema = "enterprise", catalog = "")
public class TMCorpCorpStockPO {
    private Integer id;
    private Integer seqId;
    private Integer org;
    private Integer subOrg;
    private Integer subId;
    private Integer subSeqId;
    private Integer selfId;

    @Basic
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SEQ_ID")
    public Integer getSeqId() {
        return seqId;
    }

    public void setSeqId(Integer seqId) {
        this.seqId = seqId;
    }

    @Basic
    @Column(name = "ORG")
    public Integer getOrg() {
        return org;
    }

    public void setOrg(Integer org) {
        this.org = org;
    }

    @Basic
    @Column(name = "SUB_ORG")
    public Integer getSubOrg() {
        return subOrg;
    }

    public void setSubOrg(Integer subOrg) {
        this.subOrg = subOrg;
    }

    @Basic
    @Column(name = "SUB_ID")
    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    @Basic
    @Column(name = "SUB_SEQ_ID")
    public Integer getSubSeqId() {
        return subSeqId;
    }

    public void setSubSeqId(Integer subSeqId) {
        this.subSeqId = subSeqId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TMCorpCorpStockPO that = (TMCorpCorpStockPO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(seqId, that.seqId) &&
                Objects.equals(org, that.org) &&
                Objects.equals(subOrg, that.subOrg) &&
                Objects.equals(subId, that.subId) &&
                Objects.equals(subSeqId, that.subSeqId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, seqId, org, subOrg, subId, subSeqId);
    }
    @Id
    @Basic
    @Column(name = "SELF_ID")
    public Integer getSelfId() {
        return selfId;
    }

    public void setSelfId(Integer selfId) {
        this.selfId = selfId;
    }
}
