package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "t_corp_stock", schema = "enterprise", catalog = "")
public class CorpStockPO implements Serializable {
    private static final long serialVersionUID = 3176972128965536017L;
    private CorpKey corpKey;

    private String stockType;
    private String country;
    private String certificateType;
    private String certificateNo;
    private String stockName;
    private String stockCapiType;
    private Double stockCapi;
    private String stockPercent;
    private Double stockCapiDollar;
    private Double stockCapiRmb;
    private Double stockRateRmb;
    private Double stockRateDollar;
    private Date createDate;



    @Basic
    @Column(name = "STOCK_TYPE")
    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
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
    @Column(name = "CERTIFICATE_TYPE")
    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    @Basic
    @Column(name = "CERTIFICATE_NO")
    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    @Basic
    @Column(name = "STOCK_NAME")
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    @Basic
    @Column(name = "STOCK_CAPI_TYPE")
    public String getStockCapiType() {
        return stockCapiType;
    }

    public void setStockCapiType(String stockCapiType) {
        this.stockCapiType = stockCapiType;
    }

    @Basic
    @Column(name = "STOCK_CAPI")
    public Double getStockCapi() {
        return stockCapi;
    }

    public void setStockCapi(Double stockCapi) {
        this.stockCapi = stockCapi;
    }

    @Basic
    @Column(name = "STOCK_PERCENT")
    public String getStockPercent() {
        return stockPercent;
    }

    public void setStockPercent(String stockPercent) {
        this.stockPercent = stockPercent;
    }

    @Basic
    @Column(name = "STOCK_CAPI_DOLLAR")
    public Double getStockCapiDollar() {
        return stockCapiDollar;
    }

    public void setStockCapiDollar(Double stockCapiDollar) {
        this.stockCapiDollar = stockCapiDollar;
    }

    @Basic
    @Column(name = "STOCK_CAPI_RMB")
    public Double getStockCapiRmb() {
        return stockCapiRmb;
    }

    public void setStockCapiRmb(Double stockCapiRmb) {
        this.stockCapiRmb = stockCapiRmb;
    }

    @Basic
    @Column(name = "STOCK_RATE_RMB")
    public Double getStockRateRmb() {
        return stockRateRmb;
    }

    public void setStockRateRmb(Double stockRateRmb) {
        this.stockRateRmb = stockRateRmb;
    }

    @Basic
    @Column(name = "STOCK_RATE_DOLLAR")
    public Double getStockRateDollar() {
        return stockRateDollar;
    }

    public void setStockRateDollar(Double stockRateDollar) {
        this.stockRateDollar = stockRateDollar;
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
        CorpStockPO that = (CorpStockPO) o;
        return Objects.equals(corpKey, that.corpKey) &&
                Objects.equals(stockType, that.stockType) &&
                Objects.equals(country, that.country) &&
                Objects.equals(certificateType, that.certificateType) &&
                Objects.equals(certificateNo, that.certificateNo) &&
                Objects.equals(stockName, that.stockName) &&
                Objects.equals(stockCapiType, that.stockCapiType) &&
                Objects.equals(stockCapi, that.stockCapi) &&
                Objects.equals(stockPercent, that.stockPercent) &&
                Objects.equals(stockCapiDollar, that.stockCapiDollar) &&
                Objects.equals(stockCapiRmb, that.stockCapiRmb) &&
                Objects.equals(stockRateRmb, that.stockRateRmb) &&
                Objects.equals(stockRateDollar, that.stockRateDollar) &&
                Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(corpKey, stockType, country, certificateType, certificateNo, stockName, stockCapiType, stockCapi, stockPercent, stockCapiDollar, stockCapiRmb, stockRateRmb, stockRateDollar, createDate);
    }

    @EmbeddedId
    public CorpKey getCorpKey() {
        return corpKey;
    }

    public void setCorpKey(CorpKey corpKey) {
        this.corpKey = corpKey;
    }
}
