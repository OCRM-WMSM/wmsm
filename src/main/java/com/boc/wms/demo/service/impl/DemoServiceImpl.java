package com.boc.wms.demo.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boc.wms.demo.mapper.DemoMapper;
import com.boc.wms.demo.service.DemoService;

@Transactional  //开启事务
@Service
public class DemoServiceImpl implements DemoService{
	
	@Autowired
	private DemoMapper demoMapper;
    
	/**
	 * 测试事务是否生效
	 */
	@Override
	public int addDemo(Map<String,Object> map) {
		int i=demoMapper.addDemo(map);
		System.out.println("right");
		i=demoMapper.addDemo(map);
		if(i==1) {
			throw new RuntimeException("error");
		}
		return i;
	}

}
