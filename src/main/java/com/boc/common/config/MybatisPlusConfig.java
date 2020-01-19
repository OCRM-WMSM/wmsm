package com.boc.common.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.boc.common.enums.DataSourceEnum;
import com.boc.common.multiple.MultipleDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author st-wg-hjf7526
 *
 */
@Configuration
public class MybatisPlusConfig {

	@Value("${mybatis-plus.mapper-locations}")
	private String mapperLocations;
	/**
	 * mybatis-plus分页插件
	 * 
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		return paginationInterceptor;
	}

	@Bean(name="db1")
	@ConfigurationProperties(prefix="spring.datasource.druid.db1")
	public DataSource db1() {
		return DruidDataSourceBuilder.create().build();
	}
	@Bean(name="db2")
	@ConfigurationProperties(prefix="spring.datasource.druid.db2")
	public DataSource db2() {
		return DruidDataSourceBuilder.create().build();
	}
	/**
	 * 动态数据源配置
	 */
	@Bean
	@Primary
	public DataSource multipleDataSource(@Qualifier("db1") DataSource db1,@Qualifier("db2") DataSource db2) {
		MultipleDataSource multipleDataSource=new  MultipleDataSource();
		Map<Object,Object> targetDataSources=new HashMap<Object,Object>();
		targetDataSources.put(DataSourceEnum.DB1.getValue(), db1);
		targetDataSources.put(DataSourceEnum.DB2.getValue(), db2);
		multipleDataSource.setTargetDataSources(targetDataSources);
		multipleDataSource.setDefaultTargetDataSource(db1);
		return multipleDataSource;
	}
	@Bean("sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		MybatisSqlSessionFactoryBean sqlSessionFactory=new MybatisSqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(multipleDataSource(db1(), db2()));
		ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
		sqlSessionFactory.setMapperLocations(resolver.getResources(mapperLocations));
		MybatisConfiguration configuration=new MybatisConfiguration();
		configuration.setJdbcTypeForNull(JdbcType.NULL);
		configuration.setMapUnderscoreToCamelCase(true);
		configuration.setCacheEnabled(false);
		sqlSessionFactory.setConfiguration(configuration);
		sqlSessionFactory.setPlugins(new Interceptor[] {
				paginationInterceptor()
		});
		return sqlSessionFactory.getObject();
	}
}