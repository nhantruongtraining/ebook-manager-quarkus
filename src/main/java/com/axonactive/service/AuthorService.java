package com.axonactive.service;

import com.axonactive.dao.AuthorDao;
import com.axonactive.entity.Author;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AuthorService {
    @Inject
    AuthorDao authorDao;
//    @Inject
//    private Dao<Author> authorDao;

    public Optional<Author> getById(Integer id) {
        return authorDao.get(id);
    }

    public List<Author> getAll() {
        return authorDao.getAll();
    }

    public Author save(Author author) {
        authorDao.save(author);
        return author;
    }

    public Author update(Author author) {
        authorDao.update(author);
        return author;
    }

    public void delete(Author author) {
        authorDao.delete(author);
    }

}
