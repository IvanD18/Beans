package ru.rosbank.javaschool.servicerepo.configmethod;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.rosbank.javaschool.servicerepo.configmethod.repository.DemoRepository;
import ru.rosbank.javaschool.servicerepo.configmethod.service.DemoService;

public class JavaConfig {
  @Bean // не метод: BeanDefinition + Bean Creation
  public DemoRepository demoRepository() {
    return new DemoRepository();
  }

  @Bean
  public DemoService demoService() {
    return new DemoService(demoRepository()); // not method invocation: DI -> proxy
  }
}
