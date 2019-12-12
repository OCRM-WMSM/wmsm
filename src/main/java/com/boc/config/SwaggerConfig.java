package com.boc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2配置，主要用于接口文档
 * 访问地址：http://localhost:8080(端口号)/swagger-ui.html#/
 * @author st-wg-hzw14176
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).pathMapping("/")
				.apiInfo(new ApiInfoBuilder().title("客户关系管理")
						.description("客户关系管理Api").version("1.0").build())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.boc.wms"))
				.paths(PathSelectors.any())
				.build();
	}

}
