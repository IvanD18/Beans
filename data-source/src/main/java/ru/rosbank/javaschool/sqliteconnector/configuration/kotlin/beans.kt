package ru.rosbank.javaschool.sqliteconnector.configuration.kotlin

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.context.support.beans
import org.springframework.core.io.ClassPathResource

val beans = beans {
    bean {
        PropertySourcesPlaceholderConfigurer().apply {
            setLocation(ClassPathResource("db.properties"))
        }
    }
    bean<KotlinSQLiteConnector>("connector")
    bean<KotlinSQLiteDataSource>("dataSource")
}
