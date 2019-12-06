package ru.rosbank.javaschool.sqliteconnector.configuration.javaconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;

@Configuration
public class JavaConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocation(new ClassPathResource("db.properties"));
        return configurer;
    }

    @Bean
    public static DataSource dataSource(@Value("${db_url}") String url) {
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);
        return dataSource;
    }

    @Bean
    public static JavaSQLiteConnector connector(@Value("${login}") String login, @Value("${password}") String password, DataSource sqLiteDataSource) {
        return new JavaSQLiteConnector(login, password, sqLiteDataSource);
    }

}
