package org.ikropachev.projectelster.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
public class DataSourceConfig {
    //@Bean
    public DataSource oltpDatasource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/projectelster")
                .username("root")
                .password("root")
                .build();
    }

   // @Bean
    public DataSource dwhDatasource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5432/projectelster")
                .username("postgres")
                .password("root")
                .build();
    }
}
