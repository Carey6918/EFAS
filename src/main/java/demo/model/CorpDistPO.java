package demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_corp_dist", schema = "enterprise", catalog = "")
public class CorpDistPO {
    private CorpKey corpKey;
    private String distRegNo;
    private String distName;
    private String distBelongOrg;
    private Integer distCorpOrg;
    private Integer distCorpId;
    private Integer distCorpSeqId;
    private String farePlace;
    private String operManIdentNo;
    private String operManName;
    private String fareScope;
    private Date startDate;
    private Date checkDate;
    private Date createDate;



    @Basic
    @Column(name = "DIST_REG_NO")
    public String getDistRegNo() {
        return distRegNo;
    }

    public void setDistRegNo(String distRegNo) {
        this.distRegNo = distRegNo;
    }

    @Basic
    @Column(name = "DIST_NAME")
    public String getDistName() {
        return distName;
    }

    public void setDistName(String distName) {
        this.distName = distName;
    }

    @Basic
    @Column(name = "DIST_BELONG_ORG")
    public String getDistBelongOrg() {
        return distBelongOrg;
    }

    public void setDistBelongOrg(String distBelongOrg) {
        this.distBelongOrg = distBelongOrg;
    }

    @Basic
    @Column(name = "DIST_CORP_ORG")
    public Integer getDistCorpOrg() {
        return distCorpOrg;
    }

    public void setDistCorpOrg(Integer distCorpOrg) {
        this.distCorpOrg = distCorpOrg;
    }

    @Basic
    @Column(name = "DIST_CORP_ID")
    public Integer getDistCorpId() {
        return distCorpId;
    }

    public void setDistCorpId(Integer distCorpId) {
        this.distCorpId = distCorpId;
    }

    @Basic
    @Column(name = "DIST_CORP_SEQ_ID")
    public Integer getDistCorpSeqId() {
        return distCorpSeqId;
    }

    public void setDistCorpSeqId(Integer distCorpSeqId) {
        this.distCorpSeqId = distCorpSeqId;
    }

    @Basic
    @Column(name = "FARE_PLACE")
    public String getFarePlace() {
        return farePlace;
    }

    public void setFarePlace(String farePlace) {
        this.farePlace = farePlace;
    }

    @Basic
    @Column(name = "OPER_MAN_IDENT_NO")
    public String getOperManIdentNo() {
        return operManIdentNo;
    }

    public void setOperManIdentNo(String operManIdentNo) {
        this.operManIdentNo = operManIdentNo;
    }

    @Basic
    @Column(name = "OPER_MAN_NAME")
    public String getOperManName() {
        return operManName;
    }

    public void setOperManName(String operManName) {
        this.operManName = operManName;
    }

    @Basic
    @Column(name = "FARE_SCOPE")
    public String getFareScope() {
        return fareScope;
    }

    public void setFareScope(String fareScope) {
        this.fareScope = fareScope;
    }

    @Basic
    @Column(name = "START_DATE")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "CHECK_DATE")
    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    @Basic
    @Column(name = "CREATE_DATE")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CorpDistPO that = (CorpDistPO) o;

        if (distRegNo != null ? !distRegNo.equals(that.distRegNo) : that.distRegNo != null) return false;
        if (distName != null ? !distName.equals(that.distName) : that.distName != null) return false;
        if (distBelongOrg != null ? !distBelongOrg.equals(that.distBelongOrg) : that.distBelongOrg != null)
            return false;
        if (distCorpOrg != null ? !distCorpOrg.equals(that.distCorpOrg) : that.distCorpOrg != null) return false;
        if (distCorpId != null ? !distCorpId.equals(that.distCorpId) : that.distCorpId != null) return false;
        if (distCorpSeqId != null ? !distCorpSeqId.equals(that.distCorpSeqId) : that.distCorpSeqId != null)
            return false;
        if (farePlace != null ? !farePlace.equals(that.farePlace) : that.farePlace != null) return false;
        if (operManIdentNo != null ? !operManIdentNo.equals(that.operManIdentNo) : that.operManIdentNo != null)
            return false;
        if (operManName != null ? !operManName.equals(that.operManName) : that.operManName != null) return false;
        if (fareScope != null ? !fareScope.equals(that.fareScope) : that.fareScope != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (checkDate != null ? !checkDate.equals(that.checkDate) : that.checkDate != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = corpKey != null ? corpKey.hashCode() : 0;
        result = 31 * result + (distRegNo != null ? distRegNo.hashCode() : 0);
        result = 31 * result + (distName != null ? distName.hashCode() : 0);
        result = 31 * result + (distBelongOrg != null ? distBelongOrg.hashCode() : 0);
        result = 31 * result + (distCorpOrg != null ? distCorpOrg.hashCode() : 0);
        result = 31 * result + (distCorpId != null ? distCorpId.hashCode() : 0);
        result = 31 * result + (distCorpSeqId != null ? distCorpSeqId.hashCode() : 0);
        result = 31 * result + (farePlace != null ? farePlace.hashCode() : 0);
        result = 31 * result + (operManIdentNo != null ? operManIdentNo.hashCode() : 0);
        result = 31 * result + (operManName != null ? operManName.hashCode() : 0);
        result = 31 * result + (fareScope != null ? fareScope.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (checkDate != null ? checkDate.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }

    @EmbeddedId
    public CorpKey getCorpKey() {
        return corpKey;
    }

    public void setCorpKey(CorpKey corpKey) {
        this.corpKey = corpKey;
    }
}
