package org.ikropachev.projectelster.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import lombok.extern.slf4j.Slf4j;
import org.h2.tools.Server;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.sql.SQLException;
import java.util.HashMap;

@Configuration
@Slf4j
@EnableCaching
public class AppConfig {

    @Profile("!test")
    @Bean(initMethod = "start", destroyMethod = "stop")
    Server h2Server() throws SQLException {
        log.info("Start H2 TCP server");
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }

    @Profile("!test")
    @Bean(initMethod = "start", destroyMethod = "stop")
    Server hsqldbServer() throws SQLException {
        log.info("Start hsql TCP server");
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9095");
    }

    @Bean
    Module module() {
        return new Hibernate5Module();
    }

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
    }
    /*
    @Bean(name = "oltpDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.oltp")
    public DataSource oltpDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dwhDataSource")
    @ConfigurationProperties(prefix="spring.datasource.dwh")
    public DataSource dwhDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate oltpJdbcTemplate(@Qualifier("oltpDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JdbcTemplate dwhJdbcTemplate(@Qualifier("dwhDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

     */
}
