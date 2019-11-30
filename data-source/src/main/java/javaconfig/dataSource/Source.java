package javaconfig.dataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
@PropertySource("file:/home/ivan/Рабочий стол/01. Configuration/data-source/src/main/resources/db.properties")
public class Source {

    @Autowired
    Environment env;
    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("driverClassName"));
        dataSource.setUrl(env.getProperty("url"));
        dataSource.setUsername(env.getProperty("login"));
        dataSource.setPassword(env.getProperty("password"));
        return dataSource;
    }
}

