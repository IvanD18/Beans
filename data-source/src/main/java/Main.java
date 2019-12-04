import mykotlin.ConnectKt;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import programmatic.ProgrammaticPropertyPlaceholderConfigurer;
import programmatic.Source;

public class Main {
    public static void main(String[] args) {
        {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(javaconfig.Source.class);

            System.out.println(context.getBean("dataSource"));

        }
        {
            GenericApplicationContext context = new GenericApplicationContext();
            new XmlBeanDefinitionReader(context).loadBeanDefinitions("context.xml");
            context.refresh();
            System.out.println(context.getBean("dataSourceXml"));
        }
        {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("annotation");
            System.out.println(context.getBean("dataSourceAnnotation"));
        }
        {
            GenericGroovyApplicationContext context = new GenericGroovyApplicationContext("connect.groovy");
            System.out.println(context.getBean("dataSourceGroovy"));
        }

        {
            DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
            factory.setAutowireCandidateResolver(new QualifierAnnotationAutowireCandidateResolver());
            GenericApplicationContext context = new GenericApplicationContext(factory);
            ConnectKt.getBeans().initialize(context);
            context.refresh();
            System.out.println(context.getBean("dataSourceKotlin"));
        }

        {
            GenericApplicationContext context = new GenericApplicationContext();
            context.registerBean(ProgrammaticPropertyPlaceholderConfigurer.class);
            context.registerBean("dataSourceProgrammatic", Source.class, "${login}", "${password}", "${url}", "${driverClassName}");
            context.refresh();
            System.out.println(context.getBean("dataSourceProgrammatic"));
        }


    }
}
