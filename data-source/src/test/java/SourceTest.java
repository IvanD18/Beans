import javaconfig.Source;
import mykotlin.ConnectKt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import programmatic.ProgrammaticPropertyPlaceholderConfigurer;

import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;

class SourceTest {

    @Test
    void beanSuccessBuiltWithJavaConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Source.class);
        boolean answer= context.containsBean("dataSource");
        assertEquals(true,answer);
    }

    @Test
    void beanSuccessBuiltWithAnnotationConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("annotation");
        boolean answer= context.containsBean("dataSourceAnnotation");
        assertEquals(true,answer);
    }
    @Test
    void beanSuccessBuiltWithXmlConfig() {
        GenericApplicationContext context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("context.xml");
        context.refresh();
        boolean answer= context.containsBean("dataSourceXml");
        assertEquals(true,answer);
    }
    @Test
    void beanSuccessBuiltWithGroovyConfig() {
        GenericGroovyApplicationContext context = new GenericGroovyApplicationContext("connect.groovy");
        boolean answer= context.containsBean("dataSourceGroovy");
        assertEquals(true,answer);
    }
    @Test
    void beanSuccessBuiltWithKotlinConfig() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.setAutowireCandidateResolver(new QualifierAnnotationAutowireCandidateResolver());
        GenericApplicationContext context = new GenericApplicationContext(factory);
        ConnectKt.getBeans().initialize(context);
        context.refresh();
        boolean answer= context.containsBean("dataSourceKotlin");
        assertEquals(true,answer);
    }
    @Test
    void beanSuccessBuiltWithProgrammaticConfig() {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean(ProgrammaticPropertyPlaceholderConfigurer.class);
        context.registerBean("dataSourceProgrammatic", programmatic.Source.class, "${login}", "${password}", "${url}", "${driverClassName}");
        context.refresh();
        boolean answer= context.containsBean("dataSourceProgrammatic");
        assertEquals(true,answer);
    }



}