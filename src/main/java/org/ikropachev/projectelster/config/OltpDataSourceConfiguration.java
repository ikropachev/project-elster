package org.ikropachev.projectelster.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@Slf4j
@EnableCaching
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "org.ikropachev.projectelster.repository.oltp",
        entityManagerFactoryRef = "oltpEntityManagerFactory",
        transactionManagerRef = "oltpTransactionManager")
public class OltpDataSourceConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties("spring.jpa.datasource.oltp")
    public DataSourceProperties oltpDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.jpa.datasource.oltp.configuration")
    public DataSource oltpDataSource() {
        return oltpDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Bean(name = "oltpEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean oltpEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(oltpDataSource());
        em.setPackagesToScan(
                new String[]{"org.ikropachev.projectelster.model.oltp"});
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "create");
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean
    @Primary
    public PlatformTransactionManager oltpTransactionManager(
            final @Qualifier("oltpEntityManagerFactory") LocalContainerEntityManagerFactoryBean oltpEntityManagerFactory) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.put("show-sql", "true");
        properties.put("generate-ddl", "true");
        properties.put("hibernate.ddl-auto", "create");
        oltpEntityManagerFactory.setJpaPropertyMap(properties);
        return new JpaTransactionManager(oltpEntityManagerFactory.getObject());
    }

}
