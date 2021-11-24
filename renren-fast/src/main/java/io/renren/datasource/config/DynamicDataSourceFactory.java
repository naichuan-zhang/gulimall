package io.renren.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.renren.datasource.properties.DataSourceProperties;

import java.sql.SQLException;

/**
 * @author Naichuan Zhang
 * @since 11/24/2021
 */
public class DynamicDataSourceFactory {

    public static DruidDataSource buildDataSource(DataSourceProperties properties) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());

        dataSource.setInitialSize(properties.getInitialSize());
        dataSource.setMaxActive(properties.getMaxActive());
        dataSource.setMinIdle(properties.getMinIdle());
        dataSource.setMaxWait(properties.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
        dataSource.setMaxEvictableIdleTimeMillis(properties.getMaxEvictableIdleTimeMillis());
        dataSource.setValidationQuery(properties.getValidationQuery());
        dataSource.setValidationQueryTimeout(properties.getValidationQueryTimeout());
        dataSource.setTestOnBorrow(properties.isTestOnBorrow());
        dataSource.setTestOnReturn(properties.isTestOnReturn());
        dataSource.setPoolPreparedStatements(properties.isPoolPreparedStatements());
        dataSource.setMaxOpenPreparedStatements(properties.getMaxOpenPreparedStatements());
        dataSource.setSharePreparedStatements(properties.isSharePreparedStatements());

        try {
            dataSource.setFilters(properties.getFilters());
            dataSource.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
