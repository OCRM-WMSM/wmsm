package com.boc.wms.menu.dao;

import com.boc.mapper.MenuMapper;
import com.boc.wms.menu.domain.db.MenuDb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class MenuDao {

//    @Resource
//    private MenuDao menuDao;

    @Resource
    private MenuMapper menuMapper;

    @Test
    public void testMenuDao(){
        MenuDb menuDb = menuMapper.selectById(1);
        System.out.println("!!!!!!!!!!!!!!!!!!!");
    }


}
