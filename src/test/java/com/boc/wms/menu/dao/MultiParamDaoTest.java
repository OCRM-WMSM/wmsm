package com.boc.wms.menu.dao;


import com.boc.wms.common.dao.MultiParamDao;
import com.boc.wms.common.domain.MultiParamEntity;
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
public class MultiParamDaoTest {


    @Resource
    private MultiParamDao multiParamDao;

    @Test
    public void testListMultiParamByCodeList(){
        List<String> codeList = Lists.newArrayList("EQT006","EQT007");
        List<MultiParamEntity> multiParamEntityList = multiParamDao.listMultiParamByCodeList(codeList);
        Assert.assertNotNull(multiParamEntityList);
    }

}
