package com.axonactive.dao;

import com.axonactive.entity.Author;
import com.axonactive.entity.AuthorStatus;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AuthorDaoImpl implements Dao<Author> {

    @Inject
    private EntityManager entityManager;

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
        updatedAuthor.setDateOfBirth(author.getDateOfBirth());
        updatedAuthor.setStatus(author.getStatus());
    }

    @Override
    public void delete(Author author) {
        entityManager.remove(author);
    }
}
