package com.boc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * springboot 启动类，此类需要放在最外层
 * @author st-wg-hzw14176
 *
 */
@SpringBootApplication
@EnableTransactionManagement  //开启声明式事务
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
