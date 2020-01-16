package com.boc.wms.common.controller;

import com.boc.api.ApiResult;
import com.boc.api.ApiResultCode;
import com.boc.wms.common.domain.ParamEntity;
import com.boc.wms.common.domain.ParamOpEntity;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/config")
public class ConfigController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ConfigController.class);

    @RequestMapping(value = "/multiparam",method = RequestMethod.GET)
    public ApiResult queryMultiParam(@RequestParam(value = "codeList",required = false) List<String> codeList){
        LOGGER.info("获取多值参数 {}",codeList);
        List<ParamEntity> paramEntityList = Lists.newArrayList();
        ParamEntity paramEntity = new ParamEntity();
        paramEntity.setCode("CRM143");
        paramEntity.setName("证件类型");
        paramEntity.setParamGrp("");
        paramEntity.setParamTyp("CRM");
        paramEntity.setSeqMult(1L);
        ParamOpEntity opEntity = new ParamOpEntity();
        opEntity.setOptionText("身份证");
        opEntity.setOptionValue("01");
        opEntity.setSeq(1);
        opEntity.setSeqMultOp(1022L);
        List<ParamOpEntity> opEntityList = Lists.newArrayList();
        opEntityList.add(opEntity);
        paramEntity.setParamOpEntity(opEntityList);
        paramEntityList.add(paramEntity);
        return new ApiResult(ApiResultCode.SUCCESS.getCode(),ApiResultCode.SUCCESS.getMessage(),paramEntityList);

    }
}
