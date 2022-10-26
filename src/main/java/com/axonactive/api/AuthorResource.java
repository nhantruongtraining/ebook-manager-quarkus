package com.axonactive.api;

import com.axonactive.entity.Author;
import com.axonactive.impl.AuthorDaoImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("authors")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {

    private AuthorDaoImpl authorDao;

    @GET
    public List<Author> getAll() {
        return authorDao.getAll();
    }

    @GET
    @Path("/{id}")
    public Optional<Author> getById(Integer id) {
        return authorDao.getById(id);
    }
}
