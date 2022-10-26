package com.axonactive.impl;

import com.axonactive.dao.AuthorDao;
import com.axonactive.entity.Author;

import java.util.List;
import java.util.Optional;

public class AuthorDaoImpl {



    private AuthorDao authorDao;
//    private Dao<Author> authorDao;

    public Optional<Author> getById(Integer id) {
        return authorDao.get(id);
    }

    public List<Author> getAll() {
        return authorDao.getAll();
    }
}
