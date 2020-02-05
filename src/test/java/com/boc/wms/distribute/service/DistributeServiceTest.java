package com.boc.wms.distribute.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boc.wms.distribute.domain.Distribute;
import com.boc.wms.menu.dao.MenuDao;
import com.boc.wms.menu.domain.entity.MenuEntity;
import com.boc.wms.menu.domain.entity.RoleMenuAggre;
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
public class DistributeServiceTest {

    @Resource
    private DistributeService distributeService;

    @Test
    public void testListRoleMenuByRoleId(){
    	Page<Distribute> page = new Page<>(currentPage, pageSize);
//        RoleMenuAggre roleMenuAggreList = distributeService.queryDistribution(page, d);
        page = distributeService.queryDistribution(page, d);
        Assert.assertNotNull(page);
    }


}
