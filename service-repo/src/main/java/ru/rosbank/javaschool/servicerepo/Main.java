package ru.rosbank.javaschool.servicerepo;

import lombok.val;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import ru.rosbank.javaschool.servicerepo.kotlin.BeansKt;
import ru.rosbank.javaschool.servicerepo.programmatic.repository.DemoRepository;
import ru.rosbank.javaschool.servicerepo.programmatic.service.DemoService;

public class Main {
  public static void main(String[] args) {
    {
      val context = new ClassPathXmlApplicationContext("context.xml");
      System.out.println(context.getBean(ru.rosbank.javaschool.servicerepo.xml.service.DemoService.class).getRepository());
    }
    {
      val context = new ClassPathXmlApplicationContext("scan.xml");
      System.out.println(context.getBean(ru.rosbank.javaschool.servicerepo.annotation.service.DemoService.class).getRepository());
    }
    {
      val context = new AnnotationConfigApplicationContext("ru.rosbank.javaschool.servicerepo.annotation");
      System.out.println(context.getBean(ru.rosbank.javaschool.servicerepo.annotation.service.DemoService.class).getRepository());
    }
    {
      val context = new AnnotationConfigApplicationContext(ru.rosbank.javaschool.servicerepo.configmethod.JavaConfig.class);
      System.out.println(context.getBean(ru.rosbank.javaschool.servicerepo.configmethod.service.DemoService.class).getRepository());
    }
    {
      val context = new AnnotationConfigApplicationContext(ru.rosbank.javaschool.servicerepo.configparam.JavaConfig.class);
      System.out.println(context.getBean(ru.rosbank.javaschool.servicerepo.configparam.service.DemoService.class).getRepository());
    }
    {
      val context = new GenericApplicationContext();
      context.registerBean(DemoService.class);
      context.registerBean(DemoRepository.class);
      // refresh
      context.refresh();
      System.out.println(context.getBean(ru.rosbank.javaschool.servicerepo.programmatic.service.DemoService.class).getRepository());
    }
    {
      val context = new GenericGroovyApplicationContext("context.groovy");
      System.out.println(context.getBean(ru.rosbank.javaschool.servicerepo.groovy.service.DemoService.class).getRepository());
    }
    {
      val context = new GenericApplicationContext();
      BeansKt.getBeans().initialize(context);
      context.refresh();
      System.out.println(context.getBean(ru.rosbank.javaschool.servicerepo.kotlin.service.DemoService.class).getRepository());
    }
  }
}
