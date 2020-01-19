package com.boc.wms.common.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("ocrm_mult_op")
public class MultiOpDb {
    @TableId(value = "ocrm_mult_op")
    private Integer ocrmMultOp;

    /**
     * ocrm_multiparams中的唯一键
     */
    private Integer seqMult;

    /**
     * 排序权重，越小越靠前
     */
    private Integer seq;

    private String optionText = "";

    private String optionValue = "";

    private String optionDsc = "";

    //有效性，1-有效，0-无效
    @TableLogic(value = "1")
    private Integer sts;


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

    public String getOptionDsc() {
        return optionDsc;
    }

    public void setOptionDsc(String optionDsc) {
        this.optionDsc = optionDsc;
    }

    public Integer getSts() {
        return sts;
    }

    public void setSts(Integer sts) {
        this.sts = sts;
    }
}
