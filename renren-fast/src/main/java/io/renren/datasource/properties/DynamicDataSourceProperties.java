package io.renren.datasource.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Naichuan Zhang
 * @since 11/24/2021
 */
@ConfigurationProperties(prefix = "dynamic")
public class DynamicDataSourceProperties {

    private Map<String, DataSourceProperties> dataSource = new LinkedHashMap<>();

    public Map<String, DataSourceProperties> getDataSource() {
        return dataSource;
    }

    public void setDataSource(Map<String, DataSourceProperties> dataSource) {
        this.dataSource = dataSource;
    }
}
