package com.nchu.tech.database.config;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 扩张Mybatis的MybatisAutoConfiguration配置
 * Created by fujianjian on 2017/7/12.
 */
@Configuration
@AutoConfigureAfter({DataSourceConfig.class})
public class MybatisConfig extends MybatisAutoConfiguration {

    @Resource(name = "masterDataSource")
    private DataSource masterDateSource;
    @Resource(name = "slaveDataSource")
    private DataSource slaveDataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        return super.sqlSessionFactory(this.roundRobinDataSourceSourceProxy());
    }

    public AbstractRoutingDataSource roundRobinDataSourceSourceProxy() {
        ReaderWriteSpliteRoutingDataSource proxy = new ReaderWriteSpliteRoutingDataSource();
        Map<Object, Object> targetDataResources = new HashMap<>();
        targetDataResources.put(DataSourceContextHolder.DataSourceType.MASTER, masterDateSource);
        targetDataResources.put(DataSourceContextHolder.DataSourceType.SLAVE, slaveDataSource);

        proxy.setDefaultTargetDataSource(masterDateSource);
        proxy.setTargetDataSources(targetDataResources);

        return proxy;
    }

    public MybatisConfig(MybatisProperties properties, ObjectProvider<Interceptor[]> interceptorsProvider, ResourceLoader resourceLoader, ObjectProvider<DatabaseIdProvider> databaseIdProvider) {
        super(properties, interceptorsProvider, resourceLoader, databaseIdProvider);
    }
}
