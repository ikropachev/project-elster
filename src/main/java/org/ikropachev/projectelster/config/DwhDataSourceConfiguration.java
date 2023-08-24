package org.ikropachev.projectelster.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@EnableJpaRepositories(basePackages = "org.ikropachev.projectelster.repository.dwh",
        entityManagerFactoryRef = "dwhEntityManagerFactory",
        transactionManagerRef = "dwhTransactionManager")
public class DwhDataSourceConfiguration {

    @Bean
    //@Primary
    @ConfigurationProperties("spring.jpa.datasource.dwh")
    public DataSourceProperties dwhDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    //@Primary
    //@ConfigurationProperties("spring.jpa.datasource.dwh.configuration")
    public DataSource dwhDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5432/projectelster")
                .username("postgres")
                .password("root")
                .build();
    }

    @Bean(name = "dwhEntityManagerFactory")
    //@Primary
    public LocalContainerEntityManagerFactoryBean dwhEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dwhDataSource());
        em.setPackagesToScan(
                new String[]{"org.ikropachev.projectelster.model.dwh"});
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "create");
        //properties.put("database", "postgresql");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
        //properties.put("driver-class-name", "org.postgresql.Driver");
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean
    //@Primary
    public PlatformTransactionManager dwhTransactionManager(
            final @Qualifier("dwhEntityManagerFactory") LocalContainerEntityManagerFactoryBean dwhEntityManagerFactory) {
        return new JpaTransactionManager(dwhEntityManagerFactory.getObject());
    }
}
