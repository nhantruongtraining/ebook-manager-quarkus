package com.axonactive.api;

import com.axonactive.entity.Author;
import com.axonactive.service.AuthorService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/api/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {


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
}
