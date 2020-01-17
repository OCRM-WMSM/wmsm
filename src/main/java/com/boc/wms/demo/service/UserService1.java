package com.boc.wms.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.boc.wms.demo.entity.User1;
/**
 * 服务接口
 * @author st-wg-hjf7526
 *
 */
public interface UserService1  extends IService<User1>{

	void save1(User1 user);

	Object getUser(int id);

	Page<User1> selectPage1(Page<User1> page, User1 user);

}
