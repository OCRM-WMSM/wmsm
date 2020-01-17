package com.boc.wms.demo.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boc.wms.demo.entity.User1;
/**
 * mapper接口
 * @author st-wg-hjf7526
 *
 */
@Mapper
public interface UserMapper1 extends BaseMapper<User1>{
	
	void save(User1 user);

	Object getUser(int id);

	Page<User1> selectPageList(Page<User1> page, @Param ("user")User1 user);
}
