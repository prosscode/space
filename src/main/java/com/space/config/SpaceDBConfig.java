package com.space.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages="com.space.mapper" , sqlSessionFactoryRef="spaceSessionFactory")
public class SpaceDBConfig {

    @Bean(name="spaceDataSource")
    @ConfigurationProperties(prefix="datasource.space")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name="dispatchTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("spaceDataSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name="spaceSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("spaceDataSource")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }
}
