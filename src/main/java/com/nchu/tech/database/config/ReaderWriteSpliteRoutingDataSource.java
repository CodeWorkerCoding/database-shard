package com.nchu.tech.database.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 读写分离数据源路由
 * Created by fujianjian on 2017/7/12.
 */
public class ReaderWriteSpliteRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSourceType();
    }
}
