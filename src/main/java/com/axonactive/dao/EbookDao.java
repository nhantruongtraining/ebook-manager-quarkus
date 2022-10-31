package com.axonactive.dao;

import com.axonactive.entity.Ebook;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EbookDao implements Dao<Ebook>{
    @Inject
    private EntityManager entityManager;


    @Override
    public Optional<Ebook> get(Integer id) {
        return Optional.ofNullable(entityManager.find(Ebook.class, id));
    }

    @Override
    public List<Ebook> getAll() {
        return null;
    }

    @Override
    public void save(Ebook ebook) {

    }

    @Override
    public void update(Ebook ebook) {

    }

    @Override
    public void delete(Ebook ebook) {

    }
}
