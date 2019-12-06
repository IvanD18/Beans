package ru.rosbank.javaschool.sqliteconnector.configuration.annotation;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.rosbank.javaschool.sqliteconnector.connector.SQLiteConnector;

import javax.sql.DataSource;

@Getter
@ToString
@Component("connector")
public class AnnotationSQLiteConnector implements SQLiteConnector {
    private final String login;
    private final String password;
    private final DataSource dataSource;

    public AnnotationSQLiteConnector(@Value("${login}") String login, @Value("${password}") String password, DataSource dataSource) {
        this.login = login;
        this.password = password;
        this.dataSource = dataSource;
    }
}
