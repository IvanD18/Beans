package ru.rosbank.javaschool.sqliteconnector;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.sqlite.SQLiteDataSource;
import ru.rosbank.javaschool.sqliteconnector.connector.SQLiteConnector;
import ru.rosbank.javaschool.sqliteconnector.configuration.javaconfig.JavaConfiguration;
import ru.rosbank.javaschool.sqliteconnector.configuration.kotlin.BeansKt;
import ru.rosbank.javaschool.sqliteconnector.configuration.programmatic.ProgrammaticSQLiteConnector;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConfigurationTest {
    private final String login = "root";
    private final String password = "secret";
    private final String url = "sqlite:jdbc::inmemory:";

    @Test
    void createXmlConnector() {
        val context = new ClassPathXmlApplicationContext("context.xml");

        val connector = context.getBean("connector", SQLiteConnector.class);
        assertEquals(login, connector.getLogin());
        assertEquals(password, connector.getPassword());
        assertEquals(url, ((SQLiteDataSource) connector.getDataSource()).getUrl());
    }

    @Test
    void createAnnotationConnector() {
        val context = new AnnotationConfigApplicationContext("ru.rosbank.javaschool.sqliteconnector.configuration.annotation");

        val connector = context.getBean("connector", SQLiteConnector.class);
        assertEquals(login, connector.getLogin());
        assertEquals(password, connector.getPassword());
        assertEquals(url, ((SQLiteDataSource) connector.getDataSource()).getUrl());
    }

    @Test
    void createJavaConfigConnector() {
        val context = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        val connector = context.getBean("connector", SQLiteConnector.class);
        assertEquals(login, connector.getLogin());
        assertEquals(password, connector.getPassword());
        assertEquals(url, ((SQLiteDataSource) connector.getDataSource()).getUrl());
    }

    @Test
    void createProgrammaticConnector() {
        val context = new GenericApplicationContext();
        context.registerBean(PropertySourcesPlaceholderConfigurer.class, c -> c.getPropertyValues().addPropertyValue("location", new ClassPathResource("db.properties")));
        context.registerBean("dataSource", SQLiteDataSource.class, db -> db.getPropertyValues().addPropertyValue("url", "${db_url}"));
        context.registerBean("connector", ProgrammaticSQLiteConnector.class, "${login}", "${password}", new RuntimeBeanReference("dataSource"));
        context.refresh();

        val connector = context.getBean("connector", SQLiteConnector.class);
        assertEquals(login, connector.getLogin());
        assertEquals(password, connector.getPassword());
        assertEquals(url, ((SQLiteDataSource) connector.getDataSource()).getUrl());
    }

    @Test
    void createGroovyConnector() {
        val context = new GenericGroovyApplicationContext("context.groovy");

        val connector = context.getBean("connector", SQLiteConnector.class);
        assertEquals(login, connector.getLogin());
        assertEquals(password, connector.getPassword());
        assertEquals(url, ((SQLiteDataSource) connector.getDataSource()).getUrl());
    }

    @Test
    void createKotlinConnector() {
        val factory = new DefaultListableBeanFactory();
        factory.setAutowireCandidateResolver(new QualifierAnnotationAutowireCandidateResolver());
        val context = new GenericApplicationContext(factory);
        BeansKt.getBeans().initialize(context);
        context.refresh();

        val connector = context.getBean("connector", SQLiteConnector.class);
        assertEquals(login, connector.getLogin());
        assertEquals(password, connector.getPassword());
        assertEquals(url, ((SQLiteDataSource) connector.getDataSource()).getUrl());
    }
}