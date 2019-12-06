package ru.rosbank.javaschool.sqliteconnector.connector;

import javax.sql.DataSource;

public interface SQLiteConnector {
    String getLogin();
    String getPassword();
    DataSource getDataSource();
}
