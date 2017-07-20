package com.nchu.tech.database;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(
		exclude = {DataSourceAutoConfiguration.class}
)
@MapperScan(basePackages = {"com.nchu.tech.database.mapper"})
@ComponentScan(basePackages = {
		"com.nchu.tech.database"
})
public class DatabaseShardApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DatabaseShardApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DatabaseShardApplication.class, args);
	}
}
