package br.com.starcode.finance;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinanceManagerConfig {

	public static void main(String[] args) {
		SpringApplication.run(FinanceManagerConfig.class, args);
	}
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource h2DataSource(){
	    return DataSourceBuilder
	            .create()
	            .type(org.h2.jdbcx.JdbcDataSource.class)
	            .build();
	}
	
	/*
	public void test(FreeMarkerConfigurer configurer) {
		configurer.getConfiguration().addAutoImport("tmpl", "/shared/footer.ftl");
		configurer.getConfiguration().addAutoImport("tmpl", "/shared/header.ftl");
	}
	*/
	
}
