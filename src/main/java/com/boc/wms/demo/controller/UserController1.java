package com.boc.wms.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boc.wms.demo.entity.User1;
import com.boc.wms.demo.service.UserService1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 控制器
 * @author st-wg-hjf7526
 *
 */
@RestController
@Api(tags="UserController")
@RequestMapping("/UserController")
public class UserController1 {
	@Autowired
	private UserService1 userService1=null;
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/save")
	@ApiOperation(value="保存用户",notes="测试mybatis保存")
	public void save(){
		logger.info("--------------");
		User1 user=new User1();
		user.setId(1);
		user.setUsername("哈吉大师傅");
		user.setPassword("AASSDsafdadfsdf");
		userService1.save1(user);
	}
	@RequestMapping("/getUser/{id}")
	@ResponseBody
	@ApiOperation(value="查询用户",notes="测试mybatis查询")
	public String getUser(@PathVariable int id){
		logger.info("--------------");
		return userService1.getUser(id).toString();
	}
	/**
	 * 分页demo，支持排序
	 * @return
	 */
	@RequestMapping("/getUser")
	@ResponseBody
	@ApiOperation(value="查询用户list",notes="测试mybatis查询")
	public String getUserList(){
		User1 user=new User1();
		user.setId(2);
		user.setPassword("123");
		int current=1;
		int size=15;
		Page<User1> page=new Page<>(current, size);
		user.setOrderCondition(user,"id_,password","desc,asc");
		page=userService1.selectPage1(page,user);
		return JSON.toJSONString(page);
	}
	
}
