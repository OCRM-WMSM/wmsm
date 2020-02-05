package com.boc.wms.common.domain;

public class MultParamOpEntity {
    /*
     * 参数表主键
     */
    private Integer ocrmMultOp;

    /**
     * ocrm_multiparams中的唯一键
     */
    private Integer seqMult;

    /*
     * 顺序号
     */
    private Integer seq;
    /*
     * 选项名称
     */
    private String optionText = "";

    /*
     * 选项值
     */
    private String optionValue = "";
    /*
     * 状态
     */
    private Integer sts;

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    public Integer getSts() {
        return sts;
    }

    public void setSts(Integer sts) {
        this.sts = sts;
    }

    public Integer getOcrmMultOp() {
        return ocrmMultOp;
    }

    public void setOcrmMultOp(Integer ocrmMultOp) {
        this.ocrmMultOp = ocrmMultOp;
    }

    public Integer getSeqMult() {
        return seqMult;
    }

    public void setSeqMult(Integer seqMult) {
        this.seqMult = seqMult;
    }
}
