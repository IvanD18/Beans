package ru.rosbank.javaschool.servicerepo.kotlin.service;

import ru.rosbank.javaschool.servicerepo.kotlin.repository.DemoRepository;

// В Kotlin Config'е лучше не использовать Lombok
public class DemoService {
  private final DemoRepository repository;

  public DemoService(DemoRepository repository) {
    this.repository = repository;
  }

  public DemoRepository getRepository() {
    return repository;
  }
}
