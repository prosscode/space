package com.space.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages="com.space.mapper" , sqlSessionFactoryRef="dispatchSessionFactory")
public class SpaceDBConfig {

    @Primary
    @Bean(name="dispatchDataSource")
    @ConfigurationProperties(prefix="datasource.space")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name="dispatchTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("dispatchDataSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name="dispatchSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dispatchDataSource")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }
}
