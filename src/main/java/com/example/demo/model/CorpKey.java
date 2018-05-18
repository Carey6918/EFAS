package com.example.demo.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Corp的联合主键列
 */
@Embeddable
public class CorpKey implements Serializable {
    private Integer org;
    private Integer id;
    private Integer seqId;

    public CorpKey() {
    }

    public CorpKey(Integer org, Integer id, Integer seqId) {
        this.org = org;
        this.id = id;
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
}
