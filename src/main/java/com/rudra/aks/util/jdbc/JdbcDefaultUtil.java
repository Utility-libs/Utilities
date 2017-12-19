package com.rudra.aks.util.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.rudra.aks.util.configuration.DataSourceUtilImpl;

@Configuration
public class JdbcDefaultUtil {

	
	@Bean("defaultTemplate")
	public JdbcTemplate	getJdbcTemplate() {
		return new JdbcTemplate(getDefault());
		
	}
	
	
	@Bean
	@Primary
	public	PlatformTransactionManager	txManagerDefault() {
		return new DataSourceTransactionManager(getDefault());
	}
	
		
	DataSource	getDefault() {
		return DataSourceUtilImpl.getDataSourceUtil().getMySQLDataSource();
	}
	
}
