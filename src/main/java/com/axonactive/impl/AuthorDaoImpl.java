package com.axonactive.impl;

import com.axonactive.dao.AuthorDao;
import com.axonactive.entity.Author;

import javax.ws.rs.WebApplicationException;
import java.util.List;
import java.util.Optional;

public class AuthorDaoImpl {

    private AuthorDao authorDao;
//    private Dao<Author> authorDao;

    public Optional<Author> getById(Integer id) {
        Optional<Author> author = authorDao.get(id);
        if (author == null) {
            throw new WebApplicationException("Ebook with id of " + id + " does not exist.", 404);
        }
        return author;
    }

    public List<Author> getAll() {
        return authorDao.getAll();
    }
}
