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
    private AuthorService authorDao;

    @Inject
    AuthorResource(AuthorService authorDao) {
        this.authorDao = authorDao;
    }


    @GET
    public List<Author> getAll() {
        return authorDao.getAll();
    }

    @GET
    @Path("/{id}")
    public Optional<Author> getById(@PathParam("id") Integer id) {
        return authorDao.getById(id);
    }

    @POST
    @Transactional
    public Response create(Author author) {
        authorDao.save(author);
        return Response.ok(author).status(201).build();
    }

    @PUT
    @Transactional
    public Author update(Author author) {
        authorDao.update(author);
        return author;
    }

    @DELETE
    @Transactional
    public Response delete(Author author) {
        Author authorToBeDeleted = entityManager.find(Author.class, author.getId());
        authorDao.delete(authorToBeDeleted);
        return Response.ok(author).status(204).build();
    }
}
