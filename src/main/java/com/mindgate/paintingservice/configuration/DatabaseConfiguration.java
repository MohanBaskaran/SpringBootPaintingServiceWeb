package com.mindgate.paintingservice.configuration;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfiguration {
	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource")
	public DataSourceProperties dataSourceProperties() {
		System.out.println("DataSourceProperties in DatabaseConfiguration ");
		return new DataSourceProperties();
	}

	@Bean(name = "dataSource")
	@Primary
	@ConfigurationProperties("spring.datasource")
	public DataSource dataSource() {
		return dataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Bean(name = "jdbcTemplate")
	@DependsOn("dataSource")
	public JdbcTemplate abcjdbcTemplate(@Qualifier("dataSource") DataSource abcdataSource) {
		return new JdbcTemplate(abcdataSource);
	}

}
