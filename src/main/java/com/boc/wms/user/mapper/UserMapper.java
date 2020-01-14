package com.boc.wms.user.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.boc.wms.user.vo.Employee;

@Mapper
public interface UserMapper {
	
	public Employee findUserById(String userId);

}
