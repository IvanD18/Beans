import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.sqlite.SQLiteDataSource
import ru.rosbank.javaschool.sqliteconnector.configuration.groovy.GroovySQLiteConnector

beans {
    propertyPlaceholderConfigurer PropertySourcesPlaceholderConfigurer, {
        location = 'classpath:db.properties'
    }

    dataSource SQLiteDataSource, {
        url = '${db_url}'
    }

    connector GroovySQLiteConnector, '${login}', '${password}', ref(dataSource)
}

