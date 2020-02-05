package com.boc.wms.menu.service;

import com.boc.wms.common.domain.ParamEntity;
import com.boc.wms.common.service.MultiParamService;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class MultParamServiceTest {


    @Resource
    private MultiParamService multiParamService;

    @Test
    public void testListMultiParamByCodeList(){
        List<String> codeList = Lists.newArrayList("EQT006","EQT007");
        List<ParamEntity> paramEntityList = multiParamService.listMultiParamByCodeList(codeList);
        Assert.assertNotNull(paramEntityList);
    }


}
