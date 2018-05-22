package com.example.demo.model;

public class CorpStockVO {
    private String stockName;
    private Double stockCapi;
    private String stockPercent;
    private String stockType;

    public CorpStockVO(String stockName, Double stockCapi, String stockPercent, String stockType) {
        this.stockName = stockName;
        this.stockCapi = stockCapi;
        this.stockPercent = stockPercent;
        this.stockType = stockType;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Double getStockCapi() {
        return stockCapi;
    }

    public void setStockCapi(Double stockCapi) {
        this.stockCapi = stockCapi;
    }

    public String getStockPercent() {
        return stockPercent;
    }

    public void setStockPercent(String stockPercent) {
        this.stockPercent = stockPercent;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }
}
