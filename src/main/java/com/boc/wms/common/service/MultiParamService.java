package com.boc.wms.common.service;

import com.boc.wms.common.domain.ParamEntity;

import java.util.List;


public interface MultiParamService {
    /**
     *  根据ocrm_multi_params中的code获取多值参数
     * @param codeList
     * @return
     */
    List<ParamEntity> listMultiParamByCodeList(List<String> codeList);
}
