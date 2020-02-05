package com.boc.wms.menu.dao;

import com.boc.wms.menu.domain.db.MenuDb;
import com.boc.wms.menu.domain.entity.MenuEntity;
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
public class MenuDaoTest {

    @Resource
    private MenuDao menuDao;

    @Test
    public void testListMenuEntityByIdList(){
        List<Integer> menuIdList = Lists.newArrayList(1);
        List<MenuEntity> menuEntityList = menuDao.listMenuEntityByIdList(menuIdList);
        Assert.assertNotNull(menuEntityList);
    }


}
