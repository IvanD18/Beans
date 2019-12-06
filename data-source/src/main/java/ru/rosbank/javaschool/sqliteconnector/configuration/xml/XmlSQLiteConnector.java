package ru.rosbank.javaschool.sqliteconnector.configuration.xml;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import ru.rosbank.javaschool.sqliteconnector.connector.SQLiteConnector;

import javax.sql.DataSource;

@Getter
@ToString
@RequiredArgsConstructor
public class XmlSQLiteConnector implements SQLiteConnector {
    private final String login;
    private final String password;
    private final DataSource dataSource;
}
