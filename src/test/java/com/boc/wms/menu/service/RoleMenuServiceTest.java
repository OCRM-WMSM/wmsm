package com.boc.wms.menu.service;

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
public class RoleMenuServiceTest {

    @Resource
    private RoleMenuService roleMenuService;

    @Test
    public void testListRoleMenuByRoleId(){
        RoleMenuAggre roleMenuAggreList = roleMenuService.getRoleMenuByRoleId(1);
        Assert.assertNotNull(roleMenuAggreList);
    }


}
