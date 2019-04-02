package com.pp.learn.demo.config.mast;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.url}")
    private String datasourceUrl;
//解决链接超时问题 ?autoReconnect=true&amp;failOverReadOnly=false

    //对接前置库
    @Bean
    @Primary
    public DataSource sqliteDataSource() throws ClassNotFoundException {
        Class.forName(driverClassName);
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(datasourceUrl);
        config.setUsername("root");
        config.setPassword("root");
        return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate sqliteJdbcTemplate() throws ClassNotFoundException {
        return new JdbcTemplate(sqliteDataSource());
    }
}
