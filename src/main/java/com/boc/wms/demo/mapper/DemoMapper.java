package com.boc.wms.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface DemoMapper {
	
	public int selectDemo();
	
	public int addDemo(Map<String,Object> map);

}
