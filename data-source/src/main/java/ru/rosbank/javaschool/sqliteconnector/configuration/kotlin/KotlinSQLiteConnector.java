package ru.rosbank.javaschool.sqliteconnector.configuration.kotlin;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import ru.rosbank.javaschool.sqliteconnector.connector.SQLiteConnector;

import javax.sql.DataSource;

@Getter
@ToString
public class KotlinSQLiteConnector implements SQLiteConnector {
    private final String login;
    private final String password;
    private final DataSource dataSource;

    public KotlinSQLiteConnector(@Value("${login}") String login, @Value("${password}") String password, DataSource dataSource) {
        this.login = login;
        this.password = password;
        this.dataSource = dataSource;
    }
}
