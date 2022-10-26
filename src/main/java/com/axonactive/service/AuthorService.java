package com.axonactive.service;

import com.axonactive.dao.AuthorDaoImpl;
import com.axonactive.entity.Author;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AuthorService {
    @Inject
    AuthorDaoImpl authorDao;
//    @Inject
//    private Dao<Author> authorDao;

    public Optional<Author> getById(Integer id) {
        return authorDao.get(id);
    }

    public List<Author> getAll() {
        return authorDao.getAll();
    }
}