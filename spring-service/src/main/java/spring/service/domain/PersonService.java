package spring.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonService {

  private final PersonRepository personRepository;

  @Autowired
  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public Iterable<Person> getPersons() {
    log.info("Getting all persons");
    return personRepository.findAll();
  }

  public Person getPerson(Long id) {
    log.info("Getting person by id {}", id);
    return personRepository.findById(id).orElseThrow(() -> {
      return new RuntimeException(String.format("Person=[%s] was not found", id));
    });
  }

  public Person delete(Long id) {
    log.info("Deleting person by id {}", id);
    Person person = personRepository.findById(id).orElseThrow(() -> {
      return new RuntimeException(String.format("Person=[%s] was not found", id));
    });
    personRepository.deleteById(id);
    return person;
  }

  public Person createPerson(String name, Integer age) {
    Person person = Person.builder().name(name).age(age).build();
    log.info("Creating {}", person);
    return personRepository.save(person);
  }

  public Person updatePerson(Long id, String name, Integer age) {
    log.info("Updating person by id {}", id);
    Person person = personRepository.findById(id).orElseThrow(() -> {
      return new RuntimeException(String.format("Person=[%s] was not found", id));
    });

    if (name != null) {
      person.setName(name);
    }

    if (age != null) {
      person.setAge(age);
    }

    personRepository.save(person);
    return person;
  }

}