package com.boc.wms.demo.controller;

import com.boc.exception.BusException;
import com.boc.wms.demo.mapper.DemoMapper;
import com.boc.wms.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.Map;

/**
 * rest 风格controller
 * @author st-wg-hzw14176
 *
 */
@RestController
@RequestMapping("/demo")
@Validated  //参数校验需要加此注解
public class DemoController {
	
	@Autowired
	private DemoMapper demoMapper;
	
	@Autowired
	private DemoService demoService;
	
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	/**
	 * get 请求
	 * @return
	 */
	@GetMapping("/getHello")
	public String getHello() {
		return "getHello";
	}
	
	/**
	 * put 请求
	 * @return
	 */
	@PutMapping("/putHello")
	public String putHello() {
		return "putHello";
	}
	
	/**
	 * post请求
	 * @return
	 */
	@PostMapping("/postHello")
	public String postHello() {
		return "postHello";
	}
	
	/**
	 * rest风格会自动将实体类转换为json数据
	 * @return
	 */
	@GetMapping("/json")
	public Map<String,Object> json() {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("json1","111111111111");
		map.put("json2","222222222222");
		return map;
	}
	
	@RequestMapping("/hello")
	public Object hello() {
		return "hello";
	}
	
	
	/**
	 * 调用mapper
	 * @return
	 */
	@GetMapping("/mapper")
	public String mapper() {
		int i=demoMapper.selectDemo();
		return String.valueOf(i);
	}
	
	/**
	 * 调用mapper
	 * @return
	 */
	@GetMapping("/add")
	public String mapperAdd() {
		Map<String,Object> map=new HashMap<>();
		map.put("id",1);
		map.put("value","aaa");
 		int i=demoService.addDemo(map);
		return String.valueOf(i);
	}
	
	@GetMapping("/log")
	public int log() {
		logger.debug("----------debug");
		logger.info("----------info");
		logger.warn("----------warn");
		logger.error("----------error");
		Integer.valueOf("aaaaa");
		if(1==1) {
			throw new BusException("gggggggggggggg");
		}
		return 11;
	}
	
	@GetMapping("/pam")
	public String get(@NotEmpty(message="ssssssssssssss") @RequestParam(name="a") String a,String b) {
		return a+"----"+b;
	}


}
