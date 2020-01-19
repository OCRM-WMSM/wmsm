package com.boc.wms.common.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;


@TableName("OCRM_MULTIPARAMS")
public class MultiParamDb {

    @TableId(value = "seq_mult")
    private Integer seqMult;

    private String paramGrp = "";

    private String paramTyp = "";


    private String code = "";

    private String name = "";

    private String dsc = "";

    //有效性，1-有效，0-无效
    @TableLogic(value = "1")
    private Integer sts;

    private Date createdDate;

    private String createdBy = "";

    private Date updatedDate;

    private String updatedBy = "";


    public Integer getSeqMult() {
        return seqMult;
    }

    public void setSeqMult(Integer seqMult) {
        this.seqMult = seqMult;
    }

    public String getParamGrp() {
        return paramGrp;
    }

    public void setParamGrp(String paramGrp) {
        this.paramGrp = paramGrp;
    }

    public String getParamTyp() {
        return paramTyp;
    }

    public void setParamTyp(String paramTyp) {
        this.paramTyp = paramTyp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public Integer getSts() {
        return sts;
    }

    public void setSts(Integer sts) {
        this.sts = sts;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
