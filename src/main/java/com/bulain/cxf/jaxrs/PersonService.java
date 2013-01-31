package com.bulain.cxf.jaxrs;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/persons/")
public interface PersonService {

    @GET
    @Path("/")
    List<Person> list();

    @GET
    @Path("/{id}")
    Person get(@PathParam("id") Long id);

    @POST
    @Path("/")
    void create(Person person);

    @PUT
    @Path("/{id}")
    void update(@PathParam("id") Long id, Person person);

    @DELETE
    @Path("/{id}")
    void delete(@PathParam("id") Long id);

}