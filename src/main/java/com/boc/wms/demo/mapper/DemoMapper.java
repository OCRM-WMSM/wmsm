package com.boc.wms.demo.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoMapper {
	
	public int selectDemo();
	
	public int addDemo(Map<String,Object> map);

}
