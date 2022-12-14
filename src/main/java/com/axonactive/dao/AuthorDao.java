package com.axonactive.dao;

import com.axonactive.entity.Author;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AuthorDao implements Dao<Author> {

    @Inject
    final EntityManager entityManager;

    public AuthorDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Author> get(Integer id) {
        return Optional.ofNullable(entityManager.find(Author.class, id));
    }

    @Override
    public List<Author> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Author> criteriaQuery = builder.createQuery(Author.class);
        Root<Author> root = criteriaQuery.from(Author.class);
        criteriaQuery.select(root);
//        criteriaQuery.orderBy(builder.asc(root.get("id")));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void save(Author author) {
        entityManager.persist(author);
    }

    @Override
    public void update(Author author) {
        Author updatedAuthor = entityManager.find(Author.class, author.getId());
        updatedAuthor.setFirstName(author.getFirstName());
        updatedAuthor.setLastName(author.getLastName());
        updatedAuthor.setCountry(author.getCountry());
        updatedAuthor.setDateOfBirth(author.getDateOfBirth());
        updatedAuthor.setStatus(author.getStatus());
    }

    @Override
    public void delete(Author author) {
        entityManager.remove(author);
    }
}
