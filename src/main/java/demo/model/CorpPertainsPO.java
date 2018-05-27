package demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_corp_pertains", schema = "enterprise", catalog = "")
public class CorpPertainsPO {
    private CorpKey corpKey;
    private String cretificateType;
    private String personName;
    private String personType;
    private String cretificate;
    private String selectType;
    private Date holdpostStart;
    private Date holdpostEnd;
    private String sex;
    private String age;
    private String country;
    private Date createDate;

    @Basic
    @Column(name = "CRETIFICATE_TYPE")
    public String getCretificateType() {
        return cretificateType;
    }

    public void setCretificateType(String cretificateType) {
        this.cretificateType = cretificateType;
    }

    @Basic
    @Column(name = "PERSON_NAME")
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Basic
    @Column(name = "PERSON_TYPE")
    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    @Basic
    @Column(name = "CRETIFICATE")
    public String getCretificate() {
        return cretificate;
    }

    public void setCretificate(String cretificate) {
        this.cretificate = cretificate;
    }

    @Basic
    @Column(name = "SELECT_TYPE")
    public String getSelectType() {
        return selectType;
    }

    public void setSelectType(String selectType) {
        this.selectType = selectType;
    }

    @Basic
    @Column(name = "HOLDPOST_START")
    public Date getHoldpostStart() {
        return holdpostStart;
    }

    public void setHoldpostStart(Date holdpostStart) {
        this.holdpostStart = holdpostStart;
    }

    @Basic
    @Column(name = "HOLDPOST_END")
    public Date getHoldpostEnd() {
        return holdpostEnd;
    }

    public void setHoldpostEnd(Date holdpostEnd) {
        this.holdpostEnd = holdpostEnd;
    }

    @Basic
    @Column(name = "SEX")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "AGE")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Basic
    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

        CorpPertainsPO that = (CorpPertainsPO) o;

        if (cretificateType != null ? !cretificateType.equals(that.cretificateType) : that.cretificateType != null)
            return false;
        if (personName != null ? !personName.equals(that.personName) : that.personName != null) return false;
        if (personType != null ? !personType.equals(that.personType) : that.personType != null) return false;
        if (cretificate != null ? !cretificate.equals(that.cretificate) : that.cretificate != null) return false;
        if (selectType != null ? !selectType.equals(that.selectType) : that.selectType != null) return false;
        if (holdpostStart != null ? !holdpostStart.equals(that.holdpostStart) : that.holdpostStart != null)
            return false;
        if (holdpostEnd != null ? !holdpostEnd.equals(that.holdpostEnd) : that.holdpostEnd != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (corpKey != null ? !corpKey.equals(that.corpKey) : that.corpKey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cretificateType != null ? cretificateType.hashCode() : 0;
        result = 31 * result + (personName != null ? personName.hashCode() : 0);
        result = 31 * result + (personType != null ? personType.hashCode() : 0);
        result = 31 * result + (cretificate != null ? cretificate.hashCode() : 0);
        result = 31 * result + (selectType != null ? selectType.hashCode() : 0);
        result = 31 * result + (holdpostStart != null ? holdpostStart.hashCode() : 0);
        result = 31 * result + (holdpostEnd != null ? holdpostEnd.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (corpKey != null ? corpKey.hashCode() : 0);
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
