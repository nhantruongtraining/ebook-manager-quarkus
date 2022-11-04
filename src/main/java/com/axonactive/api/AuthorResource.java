package com.axonactive.api;

import com.axonactive.entity.Author;
import com.axonactive.service.AuthorService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/api/authors")
@ApplicationScoped
public class AuthorResource {
    @Inject
    final EntityManager entityManager;
    final AuthorService authorService;

    @Inject
    AuthorResource(EntityManager entityManager, AuthorService authorService) {
        this.entityManager = entityManager;
        this.authorService = authorService;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> getAll() {
        return authorService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Author> getById(@PathParam("id") Integer id) {
        return authorService.getById(id);
    }

    //    @POST
//    @Transactional
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    public Response create(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName, @FormParam("dateOfBirth") String dateOfBirth, @FormParam("status")String status) {
//        authorService.save(firstName, lastName, dateOfBirth, status);
//        return Response.ok().status(201).build();
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Author author) {
        authorService.save(author);
        return Response.ok(author).status(201).build();
    }

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Author author) {
        authorService.update(author);
        return Response.ok(author).status(204).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam ("id") Integer id) {
        Author authorToBeDeleted = entityManager.find(Author.class, id);
        authorService.delete(authorToBeDeleted);
        return Response.ok(authorToBeDeleted).status(204).build();
    }
}
