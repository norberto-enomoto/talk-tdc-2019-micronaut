package com.example.domain;

import java.util.Collection;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Transactional
public class PersonService {

  @Inject
  private PersonRepository personRepository;

  private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

  public Collection<Person> getPersons() {
    log.info("Getting all persons");
    return personRepository.listAll();
  }

  public Person getPerson(Long id) {
    log.info("Getting person by id {}", id);
    return personRepository.findById(id);
  }

  public Person delete(Long id) {
    log.info("Deleting person by id {}", id);
    Optional<Person> dbPerson = Optional.ofNullable(personRepository.findById(id));
    Person person = dbPerson
        .orElseThrow(() -> new RuntimeException(String.format("Person=[%s] does not exist", id)));

    personRepository.delete(person);
    return person;
  }

  public Person createPerson(String name, Integer age) {
    Person person = new Person();
    person.setName(name);
    person.setAge(age);
    log.info("Creating {}", person);
    personRepository.persistAndFlush(person);
    return person;
  }

  public Person updatePerson(Long id, String name, Integer age) {
    log.info("Updating person by id {}", id);
    Optional<Person> dbPerson = Optional.ofNullable(personRepository.findById(id));
    Person person = dbPerson
        .orElseThrow(() -> new RuntimeException(String.format("Person=[%s] does not exist", id)));

    if (name != null) {
      person.setName(name);
    }

    if (age != null) {
      person.setAge(age);
    }

    personRepository.persistAndFlush(person);
    return person;
  }

}