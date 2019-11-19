package com.example.infra;

import com.example.domain.Person;
import com.example.domain.PersonService;
import java.util.Collection;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonController {

  @Inject
  private PersonService personService;

  @GET
  public Response getPersons() {
    Collection<Person> persons = personService.getPersons();
    return Response.ok(persons).build();
  }

  @GET
  @Path("/{id}")
  public Response getPerson(@PathParam("id") Long id) {
    Person person = personService.getPerson(id);
    return Response.ok(person).build();
  }

  @POST
  public Response createPerson(@Valid PersonPayload personPayload) {
    Person person = personService.createPerson(personPayload.getName(), personPayload.getAge());
    return Response.status(Status.CREATED).entity(person).build();
  }

  @PUT
  @Path("/{id}")
  public Response updatePerson(@PathParam("id") Long id, @Valid PersonPayload personPayload) {
    Person person = personService.updatePerson(id, personPayload.getName(), personPayload.getAge());
    return Response.ok(person).build();
  }

  @DELETE
  @Path("/{id}")
  public Response deletePerson(@PathParam("id") Long id) {
    Person person = personService.delete(id);
    return Response.ok(person).build();
  }

}