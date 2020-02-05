package com.boc.wms.common.domain;

import java.util.List;

public class ParamEntity {

    private MultiParamEntity multiParamEntity;

    /**
     * 对应的选项
     */
    private List<MultParamOpEntity> paramOpEntity;

    public ParamEntity(MultiParamEntity multiParamEntity, List<MultParamOpEntity> paramOpEntity) {
        this.multiParamEntity = multiParamEntity;
        this.paramOpEntity = paramOpEntity;
    }

    public MultiParamEntity getMultiParamEntity() {
        return multiParamEntity;
    }

    public void setMultiParamEntity(MultiParamEntity multiParamEntity) {
        this.multiParamEntity = multiParamEntity;
    }

    public List<MultParamOpEntity> getParamOpEntity() {
        return paramOpEntity;
    }

    public void setParamOpEntity(List<MultParamOpEntity> paramOpEntity) {
        this.paramOpEntity = paramOpEntity;
    }

    @Override
    public String toString() {
        return "ParamEntity{" +
                "multiParamEntity=" + multiParamEntity +
                ", paramOpEntity=" + paramOpEntity +
                '}';
    }
}
