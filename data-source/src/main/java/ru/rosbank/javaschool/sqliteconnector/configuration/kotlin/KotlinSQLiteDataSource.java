package ru.rosbank.javaschool.sqliteconnector.configuration.kotlin;

import org.springframework.beans.factory.annotation.Value;
import org.sqlite.SQLiteDataSource;

public class KotlinSQLiteDataSource extends SQLiteDataSource {
  public KotlinSQLiteDataSource(@Value("${db_url}") String url) {
    setUrl(url);
  }
}
