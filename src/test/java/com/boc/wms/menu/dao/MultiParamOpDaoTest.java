package com.boc.wms.menu.dao;


import com.boc.wms.common.dao.MultiOpDao;
import com.boc.wms.common.domain.MultParamOpEntity;
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
public class MultiParamOpDaoTest {


    @Resource
    private MultiOpDao multiOpDao;

    @Test
    public void testListMultiOpEntityByseqMultList(){
        List<Integer> codeList = Lists.newArrayList(1061186);
        List<MultParamOpEntity> multiParamEntityList = multiOpDao.listMultiOpEntityByseqMultList(codeList);
        Assert.assertNotNull(multiParamEntityList);
    }

}
