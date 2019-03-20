package micronaut.service.infra;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.validation.Validated;
import java.util.Collection;
import javax.inject.Inject;
import javax.validation.Valid;
import micronaut.service.domain.Person;
import micronaut.service.domain.PersonService;

@Controller("/persons")
@Validated
public class PersonController {

  private final PersonService personService;

  @Inject
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @Get
  public HttpResponse<Collection<Person>> getPersons() {
    Collection<Person> persons = personService.getPersons();
    return HttpResponse.ok(persons);
  }

  @Get("/{id}")
  public HttpResponse<Person> getPerson(@PathVariable String id) {
    Person person = personService.getPerson(id);
    return HttpResponse.ok(person);
  }

  @Post
  public HttpResponse<Person> createPerson(@Body @Valid PersonPayload personPayload) {
    Person person = personService.createPerson(personPayload.toPerson());
    return HttpResponse.created(person);
  }

  @Put("/{id}")
  public HttpResponse<Person> createPerson(@PathVariable String id, @Body @Valid PersonPayload personPayload) {
    Person person = personService.updatePerson(id, personPayload.toPerson());
    return HttpResponse.ok(person);
  }

  @Delete("/{id}")
  public HttpResponse<Person> deletePerson(@PathVariable String id) {
    Person person = personService.delete(id);
    return HttpResponse.ok(person);
  }

}