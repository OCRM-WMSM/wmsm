package com.boc.wms.common.domain;

import java.util.List;

public class ParamEntity {

    /*
     * 业务参数组
     */
    private String paramGrp = "";
    /*
     * 业务参数类型
     */
    private String paramTyp = "";
    /*
     * 代码
     */
    private String code = "";
    /*
     * 名称
     */
    private String name = "";

    /*
     * 状态
     */
    private Integer sts;

    /*
     * 多值参数序号
     */
    private Long seqMult;

    /**
     * 对应的选项
     */
    private List<ParamOpEntity> paramOpEntity;


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

    public Integer getSts() {
        return sts;
    }

    public void setSts(Integer sts) {
        this.sts = sts;
    }

    public Long getSeqMult() {
        return seqMult;
    }

    public void setSeqMult(Long seqMult) {
        this.seqMult = seqMult;
    }

    public List<ParamOpEntity> getParamOpEntity() {
        return paramOpEntity;
    }

    public void setParamOpEntity(List<ParamOpEntity> paramOpEntity) {
        this.paramOpEntity = paramOpEntity;
    }
}
