package com.boc.wms.common.domain;

public class ParamOpEntity {
    /*
     * 参数表主键
     */
    private Long seqMultOp;
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

    public Long getSeqMultOp() {
        return seqMultOp;
    }

    public void setSeqMultOp(Long seqMultOp) {
        this.seqMultOp = seqMultOp;
    }
}
