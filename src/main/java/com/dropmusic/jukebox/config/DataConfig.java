package com.dropmusic.jukebox.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

@Configuration
@PropertySource("app.properties")
public class DataConfig
{
    // Loads key-value pairs from app.properties into env variable.
    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory()
    {
        Resource config = new ClassPathResource("hibernate.cfg.xml");
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setConfigLocation(config);
        sessionFactory.setPackagesToScan(env.getProperty("jukebox.entity.package"));
        sessionFactory.setDataSource(dataSource());

        return sessionFactory;
    }

    @Bean
    public DataSource dataSource()
    {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(env.getProperty("jukebox.db.driver"));
        dataSource.setUrl(env.getProperty("jukebox.db.url"));
        dataSource.setUsername(env.getProperty("jukebox.db.username"));
        dataSource.setPassword(env.getProperty("jukebox.db.password"));

        return dataSource;
    }
}
