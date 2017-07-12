package com.nchu.tech.database.config;

/**
 * 数据源句柄
 * Created by fujianjian on 2017/7/12.
 */
public class DataSourceContextHolder {

    public enum DataSourceType {
        MASTER,
        SLAVE
    }

    private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<>();

    public static void setDataSourceType(DataSourceType type) {
        if (type == null) {
            throw new NullPointerException();
        }
        contextHolder.set(type);
    }

    public static DataSourceType getDataSourceType() {
        return contextHolder.get() == null ? DataSourceType.MASTER : contextHolder.get();
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }

}
