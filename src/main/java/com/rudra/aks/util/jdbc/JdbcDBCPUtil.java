package com.rudra.aks.util.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.rudra.aks.util.configuration.DataSourceUtilImpl;

@Configuration
public class JdbcDBCPUtil {

	
		
	@Bean("basicTemplate")
	@DependsOn("DataSourceUtil")
	public JdbcTemplate	getBasicTemplate() {
		return new JdbcTemplate(getDBCP2());
		
	}
	
		
	@Bean
	public	PlatformTransactionManager	txManagerDBCP() {
		return new DataSourceTransactionManager(getDBCP2());
	}
	
		
	DataSource	getDBCP2() {
		return DataSourceUtilImpl.getDataSourceUtil().getBasicDataSource();
	}
}
