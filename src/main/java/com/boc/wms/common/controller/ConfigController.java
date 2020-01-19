package com.boc.wms.common.controller;

import com.boc.api.ApiResult;
import com.boc.api.ApiResultCode;
import com.boc.wms.common.domain.ParamEntity;
import com.boc.wms.common.service.MultiParamService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/config")
public class ConfigController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ConfigController.class);

    @Resource
    private MultiParamService multiParamService;

    @RequestMapping(value = "/multiparam", method = RequestMethod.GET)
    public ApiResult queryMultiParam(@RequestParam(value = "codeList", required = false) List<String> codeList) {
        LOGGER.info("获取多值参数 {}", codeList);
        Map<String, ParamEntity> paramEntityMap = Maps.newHashMap();
        List<ParamEntity> paramEntityList = multiParamService.listMultiParamByCodeList(codeList);

        if (!CollectionUtils.isEmpty(paramEntityList)) {
            LOGGER.info("获取多值参数 paramEntityList: {}", paramEntityList);
            for (ParamEntity paramEntity : paramEntityList) {
                paramEntityMap.put(paramEntity.getMultiParamEntity().getCode(), paramEntity);
            }
            LOGGER.info("获取多值参数 paramEntityMap: {}", paramEntityMap);

        }
        return new ApiResult(ApiResultCode.SUCCESS.getCode(), ApiResultCode.SUCCESS.getMessage(), paramEntityMap);

    }

}
