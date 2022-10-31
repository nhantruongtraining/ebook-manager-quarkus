package com.axonactive.api;

import com.axonactive.entity.Author;
import com.axonactive.service.AuthorService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/api/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {
    @Inject
    private EntityManager entityManager;
    private AuthorService authorService;

    @Inject
    AuthorResource(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GET
    public List<Author> getAll() {
        return authorService.getAll();
    }

    @GET
    @Path("/{id}")
    public Optional<Author> getById(@PathParam("id") Integer id) {
        return authorService.getById(id);
    }

    @POST
    @Transactional
    public Response create(Author author) {
        authorService.save(author);
        return Response.ok(author).status(201).build();
    }

    @PUT
    @Transactional
    public Author update(Author author) {
        authorService.update(author);
        return author;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam ("id") Integer id) {
        Author authorToBeDeleted = entityManager.find(Author.class, id);
        authorService.delete(authorToBeDeleted);
        return Response.ok(authorToBeDeleted).status(204).build();
    }
}
