package com.axonactive.api;

import com.axonactive.entity.Author;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {

    @Inject
    EntityManager em;

    @GET
    public List<Author> getAllAuthors() {
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Author> criteriaQuery = builder.createQuery(Author.class);
        Root<Author> root = criteriaQuery.from(Author.class);
        criteriaQuery.select(root);
        criteriaQuery.orderBy(builder.asc(root.get("id")));

        return em.createQuery(criteriaQuery).getResultList();
    }
}
