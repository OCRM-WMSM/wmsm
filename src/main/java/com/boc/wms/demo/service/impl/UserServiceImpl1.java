package com.boc.wms.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boc.common.annotation.DataSource;
import com.boc.common.enums.DataSourceEnum;
import com.boc.wms.demo.entity.User1;
import com.boc.wms.demo.mapper.UserMapper1;
import com.boc.wms.demo.service.UserService1;
/**
 * 服务接口实现类
 * @author st-wg-hjf7526
 *
 */
@Service
@Transactional
public class UserServiceImpl1 extends ServiceImpl<UserMapper1, User1> implements UserService1 {
	@Autowired
	private UserMapper1 userMapper1=null;
//	@Override
//	@DataSource(DataSourceEnum.DB1)
//	public boolean save(User user) {
//		super.save(user);
//		User user1=new User();
//		user1.setId(2);
//		user1.setUsername("asdas阿萨达是");
//		user1.setPassword("gghhh阿斯顿大大大大大大大大大大大大大大大大大大大的地地道道调度撒大法师打发阿撒打发打发撒旦撒大法师打发撒旦,gghhh阿斯顿大大大大大大大大大大大大大大大大大大大的地地道道调度撒大法师打发阿撒打发打发撒旦撒大法师打发撒旦");
//		super.save(user1);
//		return true;
//	}
//	@Override
//	@DataSource(DataSourceEnum.DB2)
//	public User getById(Serializable id) {
//		return super.getById(id);
//	}
	
	@Override
	@DataSource(DataSourceEnum.DB1)
	public void save1(User1 user) {
		userMapper1.save(user);
		User1 user1=new User1();
		user1.setId(2);
		user1.setUsername("asdas阿萨达是");
		user1.setPassword("gghhh阿斯顿大大大大大大大大大大大大大大大大大大大的地地道道调度撒大法师打发阿撒打发打发撒旦撒大法师打发撒旦,gghhh阿斯顿大大大大大大大大大大大大大大大大大大大的地地道道调度撒大法师打发阿撒打发打发撒旦撒大法师打发撒旦");
		userMapper1.save(user1);
	}
	@Override
	@DataSource(DataSourceEnum.DB2)
	public Object getUser(int id) {
		return userMapper1.getUser(id);
	}
	@Override
	@DataSource(DataSourceEnum.DB1)
	public Page<User1> selectPage1(Page<User1> page, User1 user) {
		return userMapper1.selectPageList(page,user);
	}

}
