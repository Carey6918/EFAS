package demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "T_CORP", schema = "enterprise", catalog = "")
public class CorpPO implements Serializable{
    private static final long serialVersionUID = 3176972128965536016L;
    private CorpKey corpKey;
    private String regNo;
    private String corpName;
    private String addr;
    private String belongOrg;
    private String belongDistOrg;
    private String belongTrade;
    private String econKind;
    private String admitMain;
    private Date startDate;
    private Date checkDate;
    private String operManIdentNo;
    private String operManName;
    private String corpStatus;
    private Long regCapi;
    private Date fareTermStart;
    private String fareTermEnd;
    private String fareScope;
    private String uniScid;
    private String tel;
    private String webUrl;
    private String email;
    private String orgInstCode;
    private String taxpayNum;
    private String staffSize;
    private String englishName;
    private String formerName;

    public CorpPO(){}

    @Basic
    @Column(name = "REG_NO")
    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    @Basic
    @Column(name = "CORP_NAME")
    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    @Basic
    @Column(name = "ADDR")
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Basic
    @Column(name = "BELONG_ORG")
    public String getBelongOrg() {
        return belongOrg;
    }

    public void setBelongOrg(String belongOrg) {
        this.belongOrg = belongOrg;
    }

    @Basic
    @Column(name = "BELONG_DIST_ORG")
    public String getBelongDistOrg() {
        return belongDistOrg;
    }

    public void setBelongDistOrg(String belongDistOrg) {
        this.belongDistOrg = belongDistOrg;
    }

    @Basic
    @Column(name = "BELONG_TRADE")
    public String getBelongTrade() {
        return belongTrade;
    }

    public void setBelongTrade(String belongTrade) {
        this.belongTrade = belongTrade;
    }

    @Basic
    @Column(name = "ECON_KIND")
    public String getEconKind() {
        return econKind;
    }

    public void setEconKind(String econKind) {
        this.econKind = econKind;
    }

    @Basic
    @Column(name = "ADMIT_MAIN")
    public String getAdmitMain() {
        return admitMain;
    }

    public void setAdmitMain(String admitMain) {
        this.admitMain = admitMain;
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
    @Column(name = "CORP_STATUS")
    public String getCorpStatus() {
        return corpStatus;
    }

    public void setCorpStatus(String corpStatus) {
        this.corpStatus = corpStatus;
    }

    @Basic
    @Column(name = "REG_CAPI")
    public Long getRegCapi() {
        return regCapi;
    }

    public void setRegCapi(Long regCapi) {
        this.regCapi = regCapi;
    }

    @Basic
    @Column(name = "FARE_TERM_START")
    public Date getFareTermStart() {
        return fareTermStart;
    }

    public void setFareTermStart(Date fareTermStart) {
        this.fareTermStart = fareTermStart;
    }

    @Basic
    @Column(name = "FARE_TERM_END")
    public String getFareTermEnd() {
        return fareTermEnd;
    }

    public void setFareTermEnd(String fareTermEnd) {
        this.fareTermEnd = fareTermEnd;
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
    @Column(name = "UNI_SCID")
    public String getUniScid() {
        return uniScid;
    }

    public void setUniScid(String uniScid) {
        this.uniScid = uniScid;
    }

    @Basic
    @Column(name = "TEL")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "WEB_URL")
    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "ORG_INST_CODE")
    public String getOrgInstCode() {
        return orgInstCode;
    }

    public void setOrgInstCode(String orgInstCode) {
        this.orgInstCode = orgInstCode;
    }

    @Basic
    @Column(name = "TAXPAY_NUM")
    public String getTaxpayNum() {
        return taxpayNum;
    }

    public void setTaxpayNum(String taxpayNum) {
        this.taxpayNum = taxpayNum;
    }

    @Basic
    @Column(name = "STAFF_SIZE")
    public String getStaffSize() {
        return staffSize;
    }

    public void setStaffSize(String staffSize) {
        this.staffSize = staffSize;
    }

    @Basic
    @Column(name = "ENGLISH_NAME")
    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    @Basic
    @Column(name = "FORMER_NAME")
    public String getFormerName() {
        return formerName;
    }

    public void setFormerName(String formerName) {
        this.formerName = formerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CorpPO corpPO = (CorpPO) o;
        return Objects.equals(corpKey, corpPO.corpKey) &&
                Objects.equals(regNo, corpPO.regNo) &&
                Objects.equals(corpName, corpPO.corpName) &&
                Objects.equals(addr, corpPO.addr) &&
                Objects.equals(belongOrg, corpPO.belongOrg) &&
                Objects.equals(belongDistOrg, corpPO.belongDistOrg) &&
                Objects.equals(belongTrade, corpPO.belongTrade) &&
                Objects.equals(econKind, corpPO.econKind) &&
                Objects.equals(admitMain, corpPO.admitMain) &&
                Objects.equals(startDate, corpPO.startDate) &&
                Objects.equals(checkDate, corpPO.checkDate) &&
                Objects.equals(operManIdentNo, corpPO.operManIdentNo) &&
                Objects.equals(operManName, corpPO.operManName) &&
                Objects.equals(corpStatus, corpPO.corpStatus) &&
                Objects.equals(regCapi, corpPO.regCapi) &&
                Objects.equals(fareTermStart, corpPO.fareTermStart) &&
                Objects.equals(fareTermEnd, corpPO.fareTermEnd) &&
                Objects.equals(fareScope, corpPO.fareScope) &&
                Objects.equals(uniScid, corpPO.uniScid) &&
                Objects.equals(tel, corpPO.tel) &&
                Objects.equals(webUrl, corpPO.webUrl) &&
                Objects.equals(email, corpPO.email) &&
                Objects.equals(orgInstCode, corpPO.orgInstCode) &&
                Objects.equals(taxpayNum, corpPO.taxpayNum) &&
                Objects.equals(staffSize, corpPO.staffSize) &&
                Objects.equals(englishName, corpPO.englishName) &&
                Objects.equals(formerName, corpPO.formerName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(corpKey, regNo, corpName, addr, belongOrg, belongDistOrg, belongTrade, econKind, admitMain, startDate, checkDate, operManIdentNo, operManName, corpStatus, regCapi, fareTermStart, fareTermEnd, fareScope, uniScid, tel, webUrl, email, orgInstCode, taxpayNum, staffSize, englishName, formerName);
    }

    @EmbeddedId
    public CorpKey getCorpKey() {
        return corpKey;
    }

    public void setCorpKey(CorpKey corpKey) {
        this.corpKey = corpKey;
    }
}
